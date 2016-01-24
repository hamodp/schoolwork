/********************************************************************
* @ Class FrameTableEntry
* Class that defines a frame that will hold a page of task when the page 
* is in memory
* @author: Patrick Hamod hamodp@email.sc.edu
* @date: 8 Nov 2014
*/

package osp.Memory;

/**
    The FrameTableEntry class contains information about a specific page
    frame of memory.

    @OSPProject Memory
*/
import osp.Tasks.*;
import osp.Interrupts.*;
import osp.Utilities.*;
import osp.IFLModules.IflFrameTableEntry;

public class FrameTableEntry extends IflFrameTableEntry
{

	//holds the most recent time of when it was given a page
	long lastUse;
    /**
       The frame constructor. Must have

       	   super(frameID)
	   
       as its first statement.

       @OSPProject Memory
    */
    public FrameTableEntry(int frameID)
    {
        super(frameID);

    }


    /*
       Feel free to add methods/fields to improve the readability of your code
    */

}

/*
      Feel free to add local classes to improve the readability of your code
*/
