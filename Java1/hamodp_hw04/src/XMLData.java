import java.util.EmptyStackException;
import java.util.Stack;

/*********************************************************************
 * one line of xml data tag or data
 *
 * @author Patrick Hamod
 * @version 1.00 2013-02-28
**/

public class XMLData implements IXMLData{

	private boolean isTag;
	private String tagText;
	
/**********************************************************************
 * constructor
 */
	public XMLData(){}
	
	public XMLData(String tagText, boolean isTag)
	{
		this.tagText = tagText;
		this.isTag = isTag;
	}
	
/**********************************************************************
 * general purpose methods
 */

/**********************************************************************
 * tells what is contained in the line of data
 * 
 * @return closeTag
 */
	public String getTagText(){
		return tagText;
	}

/************************************************************************
 * checks to see if the next line is a tag
 * 
 * @return isTag answer to the question
 */
	public boolean isTag() {
		return isTag;
	}


}
