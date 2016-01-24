/*********************************************************************
 * IChoice interface.
 *
 * This is the interface that deals with a single choice in a cast vote.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-21
**/
public interface IChoice
{
  public String getCandidateName();

  public String getContest();

  public int getCount();

  public int compareTo(Choice that);

  public boolean equals(Object that);

  public void increment();

  public String toString();

} // public interface IChoice
