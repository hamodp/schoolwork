/*********************************************************************
 * Message interface for Homework 06.
 *
 * Copyright(C) 2013 Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell
 * @version 1.00 2013-02-17 
 *
**/
public interface IMessage<T extends Comparable<T>>
{
  public int getMessageID();

/*********************************************************************
 * Method to test if the message contains a given packet.
**/
  public boolean contains(Packet p);

/*********************************************************************
 * Method to insert a packet into this message.
**/
  public void insert(Packet p);

/*********************************************************************
 * Method to test if the message is complete.
**/
  public boolean isComplete();

/*********************************************************************
 * Usual <code>toString</code> method.
**/
  public String toString();
}
