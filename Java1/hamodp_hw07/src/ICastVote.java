import java.util.ArrayList;
/*********************************************************************
 * ICastVote.
 *
 * This is the interface that deals with a single cast vote line.
**/
public interface ICastVote
{
  public void addToCVR(String inputLine);

  public void extractPctInfo(String pctInfo);

  public ArrayList<Integer> getChoices();

  public Choice getChoiceIDForContest(String whichContest);

  public void parseNewVoteInput(String pctInfo, String inputLine);

  public String toString();

} // public interface ICastVote