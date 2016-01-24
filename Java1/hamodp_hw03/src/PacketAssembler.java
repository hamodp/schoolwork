import java.util.ArrayList;
import java.util.Scanner;

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
	private ArrayList<ArrayList<Packet>> messages;
	
/************************************************************************
 * constructor
 */
	public PacketAssembler()
	{
		messages = new ArrayList<ArrayList<Packet>>();
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
		for(ArrayList<Packet> a : messages)
		{
			
			if(a.size() == a.get(0).getPacketCount() && a.get(0).getMessageID() == messageID)
			{
				output+= "Message "+ messageID+"\n";
				for(Packet p: a)
				{
					output+= p.toString() +"\n";
				}
				messages.remove(a);
				output+= "\n";
				break;
			}
				
		}
		
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
		int test =0; // makes sure no duplicates
		int returnVal=-1;
		
		
			incoming = new Packet();
			scan =new Scanner(inFile.nextLine());
			incoming = incoming.readPacket(scan);
			if(incoming != null)
			{
				//adds the first array list to the array list
				if(messages.isEmpty())
				{
					messages.add(new ArrayList<Packet>());
					messages.get(0).add(incoming);
				}
				else
				{
					for(ArrayList<Packet> a: messages)
					{
						
						//checks the message ID of the incoming packet and if it is equal
						// it checks for where to place the packet
						if(a.get(0).getMessageID() == incoming.getMessageID())
						{
							
							//goes through all packets of a message ID
							for(Packet p: a)
							{
								test = p.getPacketID();
								
								//packet ID is lower add before any higher packet ID
								if(incoming.getPacketID() < p.compareTo(incoming))
								{
									a.add(a.indexOf(p), incoming);
									if(a.size() == incoming.getPacketCount())
									{
										returnVal = incoming.getMessageID();
									}
									break;
								}
								
								//if incoming packet has the same packet ID as array list
								//it breaks from the loop comparing packet IDs
								else if(p.compareTo(incoming) == 0)
								{
									a.set(a.indexOf(p), incoming);
									break;
								}
							}//for(Packet p: a)
							
							//skips if the packet ID = to the incoming packet
							if(test == incoming.getPacketID() )
							{
								break;
							}
							
							//adds the packet to the inner array list at the end
							else if(incoming.getPacketID() > test)
							{
								a.add(incoming);
								if(a.size() == incoming.getPacketCount())
									{
										returnVal = incoming.getMessageID();
									}
								break;
							}
						}//if(a.get(0).getMessageID() == incoming.getMessageID())
						
						
						//adds the packet if the message ID is not in the array list
						else if(a.get(0).getMessageID() != incoming.getMessageID() 
								&& messages.indexOf(a) == messages.size() -1)
						{
							messages.add(new ArrayList<Packet>());
							test = messages.size()-1;
							messages.get(test).add(incoming);
							break;
						}
					}//for(ArrayList<Packet> a: messages)
						
				}
			}//if(incoming != null)
		
		return returnVal;
	}
	

}
