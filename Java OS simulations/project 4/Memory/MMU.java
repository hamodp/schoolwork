package osp.Memory;

import java.util.*;
import osp.IFLModules.*;
import osp.Threads.*;
import osp.Tasks.*;
import osp.Utilities.*;
import osp.Hardware.*;
import osp.Interrupts.*;

/**
    The MMU class contains the student code that performs the work of
    handling a memory reference.  It is responsible for calling the
    interrupt handler if a page fault is required.

    @OSPProject Memory
*/
public class MMU extends IflMMU
{
    /** 
        This method is called once before the simulation starts. 
	Can be used to initialize the frame table and other static variables.

        @OSPProject Memory
    */
    public static void init()
    {
        for(int i=0; i<MMU.getFrameTableSize(); i++)
		{
			FrameTableEntry frame = new FrameTableEntry(i);
			MMU.setFrame(i,frame);
		}
    }

    /**
       This method handlies memory references. The method must 
       calculate, which memory page contains the memoryAddress,
       determine, whether the page is valid, start page fault 
       by making an interrupt if the page is invalid, finally, 
       if the page is still valid, i.e., not swapped out by another 
       thread while this thread was suspended, set its frame
       as referenced and then set it as dirty if necessary.
       (After pagefault, the thread will be placed on the ready queue, 
       and it is possible that some other thread will take away the frame.)
       
       @param memoryAddress A virtual memory address
       @param referenceType The type of memory reference to perform 
       @param thread that does the memory access
       (e.g., MemoryRead or MemoryWrite).
       @return The referenced page.

       @OSPProject Memory
    */
    static public PageTableEntry do_refer(int memoryAddress,
					  int referenceType, ThreadCB thread)
    {
		//the int x is the power for which 2 will be raised
        int x = getVirtualAddressBits() - getPageAddressBits();
		//the page sizze is 2^x
		int pageSize = (int) Math.pow(2,x);
		//the page id is found by taking the memory address and dividing
		//by the page size
		int pageid = memoryAddress/pageSize;
		PageTableEntry page = thread.getTask().getPageTable().pages[pageid];
		
		//check to see if the page in the memory address is valid
		//if it is change the reference bit and dirty bit if necessary
		if(page.isValid())
		{
			page.getFrame().setReferenced(true);
			if(referenceType == MemoryWrite)
			{
				page.getFrame().setDirty(true);
			}
			return page;
		}
		
		//otherwise if the thread is the thread that caused the page fault
		//suspend the thread
		if(page.getValidatingThread() == thread)
		{
		
			thread.suspend(page);
			//if the thread wasn't killed change reference and dirty bits
			if (thread.getStatus() != ThreadKill) 
			{
				page.getFrame().setReferenced(true);
				page.getFrame().setDirty(referenceType == MemoryWrite);
			}
			
			
		}
		else
		{
			//if the the there is no thread that caused the page fault
			//start a page fault
			if(page.getValidatingThread() == null)
			{
				InterruptVector.setReferenceType(PageFault);
				InterruptVector.setThread(thread);
				InterruptVector.setPage(page);
				CPU.interrupt(PageFault);
				
				//if the thread wasn't killed change reference and dirty bits
				if(thread.getStatus()!=ThreadKill)
				{
					page.getFrame().setReferenced(true);
					page.getFrame().setDirty(referenceType == MemoryWrite);
				}
			}
		}
		
		
		return page;

    }

    /** Called by OSP after printing an error message. The student can
	insert code here to print various tables and data structures
	in their state just after the error happened.  The body can be
	left empty, if this feature is not used.
     
	@OSPProject Memory
     */
    public static void atError()
    {
        // your code goes here

    }

    /** Called by OSP after printing a warning message. The student
	can insert code here to print various tables and data
	structures in their state just after the warning happened.
	The body can be left empty, if this feature is not used.
     
      @OSPProject Memory
     */
    public static void atWarning()
    {
        // your code goes here

    }


    /*
       Feel free to add methods/fields to improve the readability of your code
    */

}

/*
      Feel free to add local classes to improve the readability of your code
*/
