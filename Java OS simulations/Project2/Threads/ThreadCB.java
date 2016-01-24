/********************************************************************
* @ Class ThreadCB
* Class that handles threads aand all the methods associated with the
* thread: dispatching ready threads, creating new threads, changing
* threads statuses
* @author: Patrick Hamod hamodp@email.sc.edu
* @date: 26 Sept 2014
*/
package osp.Threads;
import java.util.Vector;
import java.util.Enumeration;
import osp.Utilities.*;
import osp.IFLModules.*;
import osp.Tasks.*;
import osp.EventEngine.*;
import osp.Hardware.*;
import osp.Devices.*;
import osp.Memory.*;
import osp.Resources.*;
import java.io.*;

/**
   This class is responsible for actions related to threads, including
   creating, killing, dispatching, resuming, and suspending threads.

   @OSPProject Threads
*/
public class ThreadCB extends IflThreadCB 
{
   
    /**
       The thread constructor. Must call 

       	   super();

       as its first statement.

       @OSPProject Threads
    */
    public ThreadCB()
    {
        super();
    }

	private static GenericList readyQueue;
	//qunatum is the number of ticks used for RR scheduling
	final static int QUANTUM = 50;
	
    /**
       This method will be called once at the beginning of the
       simulation. The student can set up static variables here.
       
       @OSPProject Threads
    */
    public static void init()
    {
        readyQueue  = new <ThreadCB> GenericList();
		
    }

    /** 
        Sets up a new thread and adds it to the given task. 
        The method must set the ready status 
        and attempt to add thread to task. If the latter fails 
        because there are already too many threads in this task, 
        so does this method, otherwise, the thread is appended 
        to the ready queue and dispatch() is called.

	The priority of the thread can be set using the getPriority/setPriority
	methods. However, OSP itself doesn't care what the actual value of
	the priority is. These methods are just provided in case priority
	scheduling is required.

	@return thread or null

        @OSPProject Threads
    */
    static public ThreadCB do_create(TaskCB task)
    {
		
		//checks to make there is a task
        if(task == null)
		{
			dispatch();
			return null;
		}

		//checks to make sure the the task can have more threads
		if(task.getThreadCount() == MaxThreadsPerTask)
		{
			dispatch();
			return null;
		}
		
		//creats new thread sets priority and 
		//associates threads and tasks
		ThreadCB newThread = new ThreadCB();
		newThread.setPriority(task.getPriority());
		newThread.setTask(task);
		newThread.setStatus(ThreadReady);
		
		//checks to see if the task added the thread
		if(task.addThread(newThread)== 0)
		{
			dispatch();
			return null;
		}
		
		//if thread is created and added to the task add to the 
		//ready queue
		readyQueue.append(newThread);
		dispatch();
		
		return newThread;
    }

    /** 
	Kills the specified thread. 

	The status must be set to ThreadKill, the thread must be
	removed from the task's list of threads and its pending IORBs
	must be purged from all device queues.
        
	If some thread was on the ready queue, it must removed, if the 
	thread was running, the processor becomes idle, and dispatch() 
	must be called to resume a waiting thread.
	
	@OSPProject Threads
    */
    public void do_kill()
    {
		//if the thread is ready remove it from the ready queue
        if(this.getStatus() == ThreadReady)
		{
			readyQueue.remove(this);
		}
		
		//if the thread is running set it to wait to die mwhahaha
		if(this.getStatus() == ThreadRunning)
		{
			context_switch(ThreadWaiting);
		}
		
		//disaccociate the task and thread then set the thread status
		//to kill
		TaskCB task = this.getTask();
		task.removeThread(this);
		this.setStatus(ThreadKill);
			
		//remove all threads waiting for IO devices from waiting queues
		for(int i = 0 ; i < Device.getTableSize(); i++)
		{
			Device.get(i).cancelPendingIO(this);
		}
			
		ResourceCB.giveupResources(this);
		
		//kill any task with no threads left
		if(task.getThreadCount() == 0)
		{
			task.kill();
		}
		
		dispatch();
		

    }

    /** Suspends the thread that is currenly on the processor on the 
        specified event. 

        Note that the thread being suspended doesn't need to be
        running. It can also be waiting for completion of a pagefault
        and be suspended on the IORB that is bringing the page in.
	
	Thread's status must be changed to ThreadWaiting or higher,
        the processor set to idle, the thread must be in the right
        waiting queue, and dispatch() must be called to give CPU
        control to some other thread.

	@param event - event on which to suspend this thread.

        @OSPProject Threads
    */
    public void do_suspend(Event event)
    {
		//if the thread is running set the status to wait
		if(this.getStatus() == ThreadRunning)
		{
			context_switch(ThreadWaiting);
		} 
		//if the thread is waiting increase the satus by one
		else if(this.getStatus()>=ThreadWaiting) 
		{
			this.setStatus(this.getStatus()+1);
		}
		//make sure the thread isn't in the ready queue and adds
		//thread to the event queue
		readyQueue.remove(this);
		event.addThread(this);
		dispatch();
    }

    /** Resumes the thread.
        
	Only a thread with the status ThreadWaiting or higher
	can be resumed.  The status must be set to ThreadReady or
	decremented, respectively.
	A ready thread should be placed on the ready queue.
	
	@OSPProject Threads
    */
    public void do_resume()
    {
		//skips this method if the thread is not waiting
        if(this.getStatus() < ThreadWaiting)
		{
			return;
		}
		//if the thread is waiting set to ready
		if(this.getStatus() == ThreadWaiting)
		{
			this.setStatus(ThreadReady);	
		}
		//decrease the amount of waiting by one 
		else if(this.getStatus() > ThreadWaiting)
		{
			this.setStatus(this.getStatus() - 1);
		}
		//if the thread was set to ready put it back in the ready queue
		if(this.getStatus() == ThreadReady)
		{
			readyQueue.append(this);
		}
		dispatch();
    }

    /** 
        Selects a thread from the run queue and dispatches it. 

        If there is just one theread ready to run, reschedule the thread 
        currently on the processor.

        In addition to setting the correct thread status it must
        update the PTBR.
	
	@return SUCCESS or FAILURE

        @OSPProject Threads
    */
    public static int do_dispatch()
    {
		//removes the currently running thread if there is one
		if(MMU.getPTBR() != null)
		{
			ThreadCB runningThread = MMU.getPTBR().getTask().getCurrentThread();
			TaskCB task = MMU.getPTBR().getTask();
			task.setCurrentThread(null);
			runningThread.setStatus(ThreadReady);
			MMU.setPTBR(null);
			readyQueue.append(runningThread);
		}
		
		//if the ready queue is empty return that is failed to dispatch
		if(readyQueue.isEmpty())
		{
			MMU.setPTBR(null);
			return FAILURE;
		}
		
		//set the next thread in the ready queue to run
		ThreadCB nextThread = (ThreadCB) readyQueue.removeHead();
		MMU.setPTBR(nextThread.getTask().getPageTable());
		nextThread.getTask().setCurrentThread(nextThread);
		nextThread.setStatus(ThreadRunning);
		//Htimer is used for the RR scheduling
		HTimer.set(QUANTUM);
		return SUCCESS;
		
    }

    /**
       Called by OSP after printing an error message. The student can
       insert code here to print various tables and data structures in
       their state just after the error happened.  The body can be
       left empty, if this feature is not used.

       @OSPProject Threads
    */
    public static void atError()
    {
        

    }

    /** Called by OSP after printing a warning message. The student
        can insert code here to print various tables and data
        structures in their state just after the warning happened.
        The body can be left empty, if this feature is not used.
       
        @OSPProject Threads
     */
    public static void atWarning()
    {
        // your code goes here
    }
    

    /*
       @method context_switch(int threadStatus)
	   this method sets the currently running thread to the input
	   status if set to ready add it back to the ready queue
	   
	   @ Param: int threadStatus set the status of the running thread
    */
	public void context_switch(int threadStatus)
	{
		//checks to see if there is a running thread
		if(MMU.getPTBR() != null)
		{
			//if this thread is the running thread give up control of the cpu
			//and change its status
			ThreadCB runningThread = MMU.getPTBR().getTask().getCurrentThread();
			if(this == runningThread)
			{
				TaskCB task = MMU.getPTBR().getTask();
				runningThread.setStatus(threadStatus);
				task.setCurrentThread(null);
				MMU.setPTBR(null);
				if(runningThread.getStatus() == ThreadReady)
				{
					readyQueue.append(runningThread);
				}
			}
		}
	}
}

/*
      Feel free to add local classes to improve the readability of your code
*/
