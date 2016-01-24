/*********************************************************************
 * IVoteCounts.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-30
**/
public interface IVoteCounts
{
  public void addToCount(Choice choice);

  public String toString();

} // public interface IVoteCounts
