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
    	//If the validating thread is equal to thread then
    	//we want to increase the lock count and return success.
    	else if(getValidatingThread() == thread)
    	{
			this.getFrame().incrementLockCount();
    		return SUCCESS;
    	}
    	/* If the validating thread is not equal to thread
    	 * then we want to suspend the thread, and if
    	 * the thread die, we want to return failure.
    	 * We also check to see if it's valid as well,
    	 * if it is valid then we want to increase the 
    	 * lock count.
    	 */
    	else//getValidatingThread() != thread)
    	{
			thread.suspend(this);
		
			if(thread.getStatus() == ThreadKill)
			{
				return FAILURE;
			}
			
			if(isValid())
			{
				this.getFrame().incrementLockCount();
				return SUCCESS;
			}
			return FAILURE;
    	}
      			
		

    }

    /** This method decreases the lock count on the page by one. 

	This method must decrement lockCount, but not below zero.

	@OSPProject Memory
    */
    public void do_unlock()
    {
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
