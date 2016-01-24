/********************************************************************
* @ Class PageTableEntry
* Class keeps track of the individual pages in memory
* @author: Patrick Hamod hamodp@email.sc.edu
* @date: 8 Nov 2014
*/
package osp.Memory;

import java.awt.Frame;

import osp.Hardware.*;
import osp.Tasks.*;
import osp.Threads.*;
import osp.Devices.*;
import osp.Utilities.*;
import osp.IFLModules.*;
/**
   The PageTableEntry object contains information about a specific virtual
   page in memory, including the page frame in which it resides.
   
   @OSPProject Memory

*/

public class PageTableEntry extends IflPageTableEntry
{
    /**
       The constructor. Must call

       	   super(ownerPageTable,pageNumber);
	   
       as its first statement.

       @OSPProject Memory
    */
    public PageTableEntry(PageTable ownerPageTable, int pageNumber)
    {
         super(ownerPageTable, pageNumber);

    }

    /**
       This method increases the lock count on the page by one. 

	The method must FIRST increment lockCount, THEN  
	check if the page is valid, and if it is not and no 
	page validation event is present for the page, start page fault 
	by calling PageFaultHandler.handlePageFault().

	@return SUCCESS or FAILURE
	FAILURE happens when the pagefault due to locking fails or the 
	that created the IORB thread gets killed.

	@OSPProject Memory
     */
    
    /* The point of this is to ensure that the page
    *  is not swapped out until it has been unlocked. 
    *  locked is not currently in a frame.
	 */
    public int do_lock(IORB iorb)
    {
		ThreadCB thread = iorb.getThread();
    	if(isValid())
    	{
    		this.getFrame().incrementLockCount();
    		return SUCCESS;
    	}
		//if no thread caused the page to be invalid page fault and increases
		//lock if the page fault succeeded
    	if(getValidatingThread() == null)
    	{
    		
    		if(PageFaultHandler.handlePageFault(thread, MemoryLock, this) == SUCCESS)
    		{
    			this.getFrame().incrementLockCount();
        		return SUCCESS;
    		}
    		else
    		{
    			return FAILURE;
    		}
    		
    	}
    	//if the thread is  the same as the one that cause the page fault increase lock
		//and return success
    	else if(getValidatingThread() == thread)
    	{
			this.getFrame().incrementLockCount();
    		return SUCCESS;
    	}
    	//if the validating thread is not equal to thread then suspend the thread
		//until the page becomes valid and increase lock 
    	else
    	{
			thread.suspend(this);
			
			//if the thread got killed return failure
			if(thread.getStatus() == ThreadKill)
			{
				return FAILURE;
			}
			
			if(isValid())
			{
				this.getFrame().incrementLockCount();
				return SUCCESS;
			}
			//if the page remains invalid return failure
			return FAILURE;
    	}
      			
		

    }

    /** This method decreases the lock count on the page by one. 

	This method must decrement lockCount, but not below zero.

	@OSPProject Memory
    */
    public void do_unlock()
    {
		//decrease the lock count if it is greater than zero
    	if(this.getFrame().getLockCount() > 0)
 		{
 			this.getFrame().decrementLockCount();
 		}

    }


    /*
       Feel free to add methods/fields to improve the readability of your code
    */

}

/*
      Feel free to add local classes to improve the readability of your code
*/
