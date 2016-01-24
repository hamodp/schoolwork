/*********************************************************************
 * Cast Vote.
 *
 * This is the class that deals with a single cast vote choice.
**/
public interface IChoice
{
//  static private int staticVoteNumber = 0;

//  private int localVoteNumber = 0;

//  boolean isNewVote;

//  private String ballotStyle;
//  private String candidateContest;
//  private String ivo;
//  private String pctName;
//  private String pctNumber;
//  private String sequenceCode;

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to extract the precinct information from the 'String'.
 *
 * Extracting the pct info means getting rid of the "PRECINCT" and
 * the hyphen from the input, taking the next piece of the 'String'
 * as the pct number, and then taking rest of the input 'String'
 * as the name of the pct.
 *
 * We make judicious use of 'trim()' in order to limit ourselves
 * only to real data.
 *
 * @param pctData the 'String' from which to extract
**/
  public void extractPctData(String pctData);

/*********************************************************************
 * Method to parse an input line to create a cast vote choice.
 *
 * First we extract the pct info from the 'pctData' input parameter.
 *
 * Then we convert the input line to a 'Scanner' and read off the
 * info one at a time.
 *
 * The only tricky part is that we may or may not have an asterisk
 * so we have a variable number of strings to extract.
 *
 * If we have the asterisk at the appropriate location, we assume
 * that we have a new vote and we bump that counter.
 *
 * @param pctData and inputLine
**/
  public void parseInput(String pctData, String inputLine);

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString();

} // public interface IChoice
