/********************************************************************
* @ Class PageFaultHandler
* Class that handles pagefaults and swaps out and swaps in pages into
* frames
* @author: Patrick Hamod hamodp@email.sc.edu
* @date: 8 Nov 2014
*/
package osp.Memory;
import java.util.*;
import osp.Hardware.*;
import osp.Threads.*;
import osp.Tasks.*;
import osp.FileSys.FileSys;
import osp.FileSys.OpenFile;
import osp.IFLModules.*;
import osp.Interrupts.*;
import osp.Utilities.*;
import osp.IFLModules.*;

/**
    The page fault handler is responsible for handling a page
    fault.  If a swap in or swap out operation is required, the page fault
    handler must request the operation.

    @OSPProject Memory
*/
public class PageFaultHandler extends IflPageFaultHandler
{
    /**
        This method handles a page fault. 

        It must check and return if the page is valid, 

        It must check if the page is already being brought in by some other
	thread, i.e., if the page's has already pagefaulted
	(for instance, using getValidatingThread()).
        If that is the case, the thread must be suspended on that page.
        
        If none of the above is true, a new frame must be chosen 
        and reserved until the swap in of the requested 
        page into this frame is complete. 

	Note that you have to make sure that the validating thread of
	a page is set correctly. To this end, you must set the page's
	validating thread using setValidatingThread() when a pagefault
	happens and you must set it back to null when the pagefault is over.

        If a swap-out is necessary (because the chosen frame is
        dirty), the victim page must be dissasociated 
        from the frame and marked invalid. After the swap-in, the 
        frame must be marked clean. The swap-ins and swap-outs 
        must are preformed using regular calls read() and write().

        The student implementation should define additional methods, e.g, 
        a method to search for an available frame.

	Note: multiple threads might be waiting for completion of the
	page fault. The thread that initiated the pagefault would be
	waiting on the IORBs that are tasked to bring the page in (and
	to free the frame during the swapout). However, while
	pagefault is in progress, other threads might request the same
	page. Those threads won't cause another pagefault, of course,
	but they would enqueue themselves on the page (a page is also
	an Event!), waiting for the completion of the original
	pagefault. It is thus important to call notifyThreads() on the
	page at the end -- regardless of whether the pagefault
	succeeded in bringing the page in or not.

        @param thread the thread that requested a page fault
        @param referenceType whether it is memory read or write
        @param page the memory page 

	@return SUCCESS is everything is fine; FAILURE if the thread
	dies while waiting for swap in or swap out or if the page is
	already in memory and no page fault was necessary (well, this
	shouldn't happen, but...). In addition, if there is no frame
	that can be allocated to satisfy the page fault, then it
	should return NotEnoughMemory

        @OSPProject Memory
    */
    public static int do_handlePageFault(ThreadCB thread, 
					 int referenceType,
					 PageTableEntry page)
    {
		
		//the booleans check to see if the if there are any free frames
		// and if there are any available frames to take for a new frame
		boolean memory = false;
		boolean free = false;
		FrameTableEntry frame =null;
		PageTableEntry oldPage = null;
		
		//if the the frame was valid a pagefault should not have been
		//made so wake all the threads and dispatch a new thread
        if(page.isValid())
		{
			page.notifyThreads();
			ThreadCB.dispatch();
			return FAILURE;
		}
		
		//create a system event to suspend the thread on 
		SystemEvent event = new SystemEvent("Thread "+ thread.getID());
		thread.suspend(event);
		page.setValidatingThread(thread);
		
		//This for loop checks for a free frame and puts the page in that frame
		for(int i=0; i<MMU.getFrameTableSize(); i++)
		{
			if(!MMU.getFrame(i).isReserved() && MMU.getFrame(i).getPage() == null && MMU.getFrame(i).getLockCount() == 0)
			{
				frame = MMU.getFrame(i);
				frame.setReserved(thread.getTask());
				free = true;
				break;
			}
		}
		//if there are no free frames find a frame that is not reserved or locked to replace
		if(! free)
		{
			long oldest = HClock.get();
			for(int i=0; i<MMU.getFrameTableSize(); i++)
			{
				if(!MMU.getFrame(i).isReserved() && MMU.getFrame(i).getLockCount() == 0 && MMU.getFrame(i).lastUse < oldest)
				{
					frame = MMU.getFrame(i);
					oldest = frame.lastUse;
					//frame.setReserved(thread.getTask());
					memory = true;
				}
			}
			//if there were no frames for the page then there is no memory
			if(!memory)
			{
				page.notifyThreads();
				ThreadCB.dispatch();
				return NotEnoughMemory;
			}
			frame.setReserved(thread.getTask());
		}
		
		//if the frame had a page then it must be checked if it is dirty
		if(frame.getPage() != null)
		{
			oldPage =  frame.getPage();
			//if the frame is dirty it must be swapped out 
			if(frame.isDirty())
			{
				oldPage.getTask().getSwapFile().write(oldPage.getID(), oldPage, thread);
				
				//this checks to see that the thread was not killed after the io event
				if(thread.getStatus()== ThreadKill)
				{
					page.notifyThreads();
					ThreadCB.dispatch();
					page.setValidatingThread(null);
					return FAILURE;
				}
				
				frame.setDirty(false);
			}
			
			//frame must set the reference bit to false ans remove the page
			//then the old page must lose its frame and set itself invalid
			frame.setReferenced(false);
			frame.setPage(null);
			oldPage.setValid(false);
			oldPage.setFrame(null);

		}
		
		//once there is no page in the target frame then we put the page into the frame
		//and swap in
		page.setFrame(frame);
		page.getTask().getSwapFile().read(page.getID(), page, thread);
		//check to make sure that the thread was not killed during the io to swap in
		if(thread.getStatus()== ThreadKill)
		{
			page.notifyThreads();
			ThreadCB.dispatch();
			return FAILURE;
		}
		
		//finally set frame to have the page
		frame.setPage(page);
		frame.lastUse= HClock.get();
		page.setValid(true);
		frame.setUnreserved(thread.getTask());
		page.notifyThreads();
		event.notifyThreads();
		ThreadCB.dispatch();
		return SUCCESS;
		
    }


}

/*
      Feel free to add local classes to improve the readability of your code
*/
