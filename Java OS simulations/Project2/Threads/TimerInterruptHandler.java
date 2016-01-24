/********************************************************************
* @ Class TimerInterruptHandler
* Class that handles the interupts sent by the ThreadsCB class and 
* dispatches a new thread
* @author: Patrick Hamod hamodp@email.sc.edu
* @date: 26 Sept 2014
*/

package osp.Threads;

import osp.IFLModules.*;
import osp.Utilities.*;
import osp.Hardware.*;

/**    
       The timer interrupt handler.  This class is called upon to
       handle timer interrupts.

       @OSPProject Threads
*/
public class TimerInterruptHandler extends IflTimerInterruptHandler
{
    /**
       This basically only needs to reset the times and dispatch
       another process.

       @OSPProject Threads
    */
    public void do_handleInterrupt()
    {
        ThreadCB.dispatch();

    }


    /*
       Feel free to add methods/fields to improve the readability of your code
    */

}

/*
      Feel free to add local classes to improve the readability of your code
*/
