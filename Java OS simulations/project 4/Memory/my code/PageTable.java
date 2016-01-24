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
		int x = MMU.getPageAddressBits();
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
