
import java.util.Scanner;
import java.util.TreeMap;

/*********************************************************************
* class Packet Assembler 
* takes the input of scrambled packets and assembles them if they are 
* complete and dumps them to the output
*
* @author Patrick Hamod
* @version 1.00 2013-02-11
**/
public class PacketAssembler implements IPacketAssembler{

	private Packet incoming; //name of the next Packet
	private TreeMap<Integer, Message> messages;
	
/************************************************************************
 * constructor
 */
	public PacketAssembler()
	{
		messages  =new TreeMap<Integer, Message>();
	}
	
/************************************************************************
 * general methods
 */
	
/************************************************************************
 * Method to dump the completed message
 * 
 * @param messageID the number of the completed message to search for
 * @return output the message and all Packets to be printed for message
 */
	public String dumpMessage(int messageID) 
	{
		String output ="\n";
		
		output += messages.get(messageID);
		messages.remove(messageID);
		
		return output;
	}

/***************************************************************************
 * Method to read a file and break it into separate lines and retrieves all
 * all the packets in the file
 * 
 * @param inFile the file to be read
 * @return returnVal the number of the complete message and its message ID
 */
	public int readPacket(Scanner inFile) 
	{
		Scanner scan;
		int returnVal=-1;
		Message message;
		
			incoming = new Packet();
			scan =new Scanner(inFile.nextLine());
			incoming = incoming.readPacket(scan);
			
			
			if(incoming != null)
			{
				//adds first message to the treemap
				if(messages.isEmpty())
				{
					message= new Message(incoming);
					messages.put(incoming.getMessageID(), message);
				}
				
				//for all other methods
				else
				{
					//if the treemap does not have tthe message in it
					//it creates a new message for messages
					if(messages.get(incoming.getMessageID()) == null)
					{
						message= new Message(incoming);
						messages.put(incoming.getMessageID(), message);
					}
					
					//if the message is in the treemap
					else
					{
						//gets the message that will get the new packet
						//then it checks if message is complete
						message = messages.get(incoming.getMessageID());
						
						message.insert(incoming);
						messages.put(message.getMessageID(), message);
						if(message.isComplete())
						{
							returnVal =message.getMessageID();
						}
						
					}//else
				}//else
			}//if(incoming != null)
		
		return returnVal;
	}
	

}
