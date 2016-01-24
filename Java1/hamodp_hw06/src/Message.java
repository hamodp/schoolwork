import java.util.Map.Entry;
import java.util.TreeMap;

/*********************************************************************
* class Message 
* takes all packets and puts them into the proper message if the same messageID
*
* @author Patrick Hamod
* @version 1.00 2013-02-11
**/
public class Message implements IMessage {

	private int fullSize;
	private int messageID;
	private TreeMap<Integer, Packet> message;

/********************************************************************************************
* constructor
*/
	public Message(Packet p)
	{
		fullSize = p.getPacketCount();
		this.messageID = p.getMessageID();
		message =new TreeMap<Integer, Packet>();
		message.put(p.getPacketID(), p);
	}
	
	
/***************************************************************************************
 * accessor
 */
/***************************************************************************************
 * accessor that returns the message id to determine if the packet is part of the message
 * 
 * @return messageID
 */		
	
	public int getMessageID() 
	{
		return messageID;
	}

/***************************************************************************************
 * general methods
 */
/***************************************************************************************
 * this method checks to see if the packet is in the message already
 * 
 * @return answer to whether packet isContained or not
 */
	public boolean contains(Packet p) 
	{
		
		return message.get(p.getPacketID()) != null;
			
	}

/***************************************************************************************
 * this method puts the packet into the tree map if it is not already contained in the 
 * treemap
 */
	public void insert(Packet p)
	{
		if(!contains(p))
		{
			message.put(p.getPacketID(), p);
		}
		
	}

/***************************************************************************************
 * this method checks to see if the message has all of its packets
 * 
 * @return answer to the question
 */
	public boolean isComplete() 
	{
		return fullSize == message.size();
	}
	
/***************************************************************************************
 * this method takes all of the packets and formats them into  a string for output
 * 
 * @return output
 */
	public String toString()
	{
		String output = "";
		for(Entry<Integer, Packet> data: message.entrySet())
		{
			output += data.getValue().toString()+"\n";
		}
		
		return output;
	}

}
