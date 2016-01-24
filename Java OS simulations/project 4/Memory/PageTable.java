/********************************************************************
* @ Class PageTable
* Class that contains the array of pages and keeps track of the owner of pages
* @author: Patrick Hamod hamodp@email.sc.edu
* @date: 8 Nov 2014
*/

package osp.Memory;
/**
    The PageTable class represents the page table for a given task.
    A PageTable consists of an array of PageTableEntry objects.  This
    page table is of the non-inverted type.

    @OSPProject Memory
*/
import java.lang.Math;
import osp.Tasks.*;
import osp.Utilities.*;
import osp.IFLModules.*;
import osp.Hardware.*;

public class PageTable extends IflPageTable
{
	private int size;

    /** 
	The page table constructor. Must call
	
	    super(ownerTask)

	as its first statement.

	@OSPProject Memory
    */
    public PageTable(TaskCB ownerTask)
    {
        super(ownerTask);
		//the int x is the power for which 2 will be raised
		// and is = MMU.getPageAddressBits();
		int x = MMU.getPageAddressBits();
		//the size of the page is 2^x
		size =(int) Math.pow(2,x);
		pages = new PageTableEntry [size];
		for(int i=0; i<size;i++)
		{
			pages[i] = new PageTableEntry(this, i); 
		}
    }

    /**
       Frees up main memory occupied by the task.
       Then unreserves the freed pages, if necessary.

       @OSPProject Memory
    */
    public void do_deallocateMemory()
    {
		//in order to deallocate all frames that contain pages that are apart
		// of the owner task, we must find, unreserve the frames, and empty
		//frames that have pages apart of this task
        for(int i=0; i<MMU.getFrameTableSize();i++)
		{
			FrameTableEntry frame = MMU.getFrame(i);
				if(frame.getReserved() == this.getTask())
				{
					frame.setUnreserved(this.getTask());
				}
				
				if(frame.getPage()==null)
				{}
				else if(frame.getPage().getTask() == this.getTask())
				{
					frame.setDirty(false);
					frame.setReferenced(false);
					frame.setPage(null);
				}
		}
    }
    /*
       Feel free to add methods/fields to improve the readability of your code
    */

}

/*
      Feel free to add local classes to improve the readability of your code
*/
