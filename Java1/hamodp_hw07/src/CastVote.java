import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;

/*********************************************************************
 * CastVote class.
 *
 * takes a cast vote and creates an array of the choices
 * all classes that were in last home work were taken from Buell's choice
 * class
 * 
 *
 * @author Duncan Buell edited by Patrick Hamod
 * @version 1.00 2013-04-22
**/
public class CastVote {

	static private int staticVoteNumber = 0;

	  private int localVoteNumber = 0;

	  private String ballotStyle;
	  private String ivo;
	  private String pctName;
	  private String pctNumber;

	  private String output ="";
	  private ArrayList<Integer> choices; //arraylist of references to choices
	  private String candidate;
	  private  String contest;
	  
	  
	  /*******************************************************************
	   *  constructor
	   *  
	   * @param pctData
	   * @param inputLine
	   */
	  CastVote(String pctData, String inputLine)
	  {
		  choices = new ArrayList<Integer>();
		  this.ballotStyle = "style";
		    this.ivo = "ivo";
		    this.localVoteNumber = staticVoteNumber;
		    this.pctName = "pctname";
		    this.pctNumber = "pctnumber";
		    this.extractPctInfo(pctData);
		    this.parseNewVoteInput(pctData, inputLine);
	  }
	  
  /*******************************************************************
   * acessors 
   */
  /********************************************************************
   * returns what the candidates are running for
   * 
   * @return contest
   */
	  public String getContest()
	  {
		  return contest;
	  }
	  
  /******************************************************************
   * returns the candidate running in the contest
   * 
   * @return candidate
   */
	  public String getCandidate()
	  {
		  return candidate;
	  }
	  
	  
  /*********************************************************************
   * creates references to the choices for each inputline
   * 
   * @param inputLine
   */
	  public void addToCVR(String inputLine)
	  {
		  String s;
		    Scanner scanLine = null;

		    scanLine = new Scanner(inputLine);
		    // read and trash the ivo number and the ballot style number
		    s = scanLine.next().trim();
		    s = scanLine.next().trim();

		    // read and trim the sequence code, name, and contest, and add
		    Choice newChoice = new Choice(scanLine.nextLine().trim());
		    Choices.AddChoice(newChoice);
		    choices.add(Choices.GetID(newChoice));
		    scanLine.close();
	  }
	  
	  
/*********************************************************************
 * general methods
 */
	  
  /******************************************************
   * takes the pct info and gets the pct number and name
   * 
   * @param pctInfo
   */
	  public void extractPctInfo(String pctInfo)
	  {
		  String s = "";
		    Scanner scanLine = null;
		    pctInfo = pctInfo.trim();
		    scanLine = new Scanner(pctInfo);

		    s = scanLine.next(); // read and toss the "PRECINCT"

		    this.pctNumber = scanLine.next();

		    s = scanLine.next(); // read and toss the hyphen

		    this.pctName = scanLine.nextLine().trim(); // read the rest of the line
		    scanLine.close();
		    
	  }

	  /***********************************************************************
	   * finds all choices pertaining to the contest
	   * 
	   * @param whichContest
	   * @return returnVal
	   */
	  public Choice getChoiceIDForContest(String whichContest)
	  {
		Choice returnVal = null;
		for(Integer id: choices)
		{
			if(Choices.GetChoice(id).getContest().indexOf(whichContest) >= 0)
			{
				returnVal = Choices.GetChoice(id);
			}
		}
		
		
		return returnVal;
	  }

	 /*****************************************************************
	  * parses and assigns all of the header data of a vote and then takes the first
	  * choice and puts it into Choices and puts the reference into the array choices
	  * 
	  * @param pctInfo
	  * @param inputLine
	  */
	  public void parseNewVoteInput(String pctInfo, String inputLine)
	  {
		  String s;
		    Scanner scanLine = null;

		    this.extractPctInfo(pctInfo);

		    scanLine = new Scanner(inputLine);
		    this.ivo = scanLine.next().trim();
		    this.ballotStyle = scanLine.next().trim();

		    if(inputLine.indexOf("*") >= 0)
		    {
		      s = scanLine.next().trim();
		      ++staticVoteNumber;
		      this.localVoteNumber = staticVoteNumber;
		    }

		    Choice newChoice = new Choice(scanLine.nextLine().trim());
		    Choices.AddChoice(newChoice);
		    choices.add(Choices.GetID(newChoice));
		    scanLine.close();

	  }
	  
/************************************************
 * to String method
 * 
 * @return vote records and the choice associated
 * with vote
 */
	  public String toString()
	  {
		  String output = "";
		  output += String.format("%5d ", this.localVoteNumber);
		   output += String.format("%5s ", this.pctNumber);
		    output += String.format("%-20s ", this.pctName);
		    output += String.format("%6s ", this.ivo);
		    output += String.format("%3s ", this.ballotStyle);
		    output += String.format("* ");

		    boolean firstTime =true;
		    for(Integer id: choices)
		    {
		    	 if(firstTime)
		         {
		           firstTime = false;
		         }
		         else
		         {
		        	 output += String.format("%46s ", " ");
		         }
		        
		      output += String.format("%-25s", Choices.GetChoice(id).getCandidateName());
		      output += String.format("%-45s\n", Choices.GetChoice(id ).getContest()); 
		    }
		    
		    return output;

	  }

/**************************************************************************
 * this method gets all the reference numbers of the arraylist choices  
 * 
 * @return choices
 */
public ArrayList<Integer> getChoices() 
{
	
	return choices;
}


}
