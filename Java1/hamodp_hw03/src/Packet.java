import java.util.Scanner;

/*********************************************************************
* class Packet
* takes a line of data reads the parts of the packet
*
* @author Patrick Hamod
* @version 1.00 2013-02-11
**/
public class Packet implements IPacket
{

	private int messageID;
	private int packetID;
	private int packetCount;
	private String payload;
	
/********************************************************************************************
 * constructor
 */
public Packet(int message,int packetnum, int packets, String data)
	{
		messageID = message;
		packetID = packetnum;
		packetCount = packets;
		payload =data;
	}
	
/****************************************************************************************
 * constructor
 */
	public Packet(){}
	
	
/****************************************************************************************
 * Method to compare the current PacketID to another Packet's ID
 * 
 * @param p another Packet to compare Packet IDs
 * @return int return the highest number unless equal then return 0
 */
	public int compareTo(Packet p) {
		int returnVal =0;
		if(p.getPacketID() < packetID)
		{
			returnVal = packetID;
		}
		
		else if(p.getPacketID() > packetID)
		{
			returnVal = p.getPacketID();
		}
		
		else
		{
			returnVal = 0;
		}
		return returnVal;
	}

/***************************************************************************************
 * accessors
 */
	
/************************************************************************************
 * method to get the Packet's message ID
 * 
 * @return messageID
 */
	public int getMessageID() 
	{
		return messageID;
	}
	
/*************************************************************************************
 * Method to get Packet's ID
 * 
 * @return PacketID
 */
	public int getPacketID() 
	{
		return packetID;
	}

/************************************************************************************
 * Method to get the number of Packets in the message
 * 
 * @return packetCount
 */
	public int getPacketCount() 
	{
		return packetCount;
	}

/************************************************************************************
 * Method to get the part of the document sent 
 * 
 * @return payload the document associated with the PacketID
 */
	public String getPayload() 
	{
		return payload;
	}

/*************************************************************************************
 * general Methods	
 */
	
/****************************************************************************
 * Method determines what the elements of the packet are 
 * and if there is no messageID it returns that the line is not a packet
 * 
 * @param inFile one line of data to parse
 * @return Packet returns a packet with with variable set
 */
	public Packet readPacket (Scanner inFile) 
	{
		int message=0;
		int packetnum=0;
		int packets=0;
		String data = "";
		Packet p;
		
		while(inFile.hasNext())
		{
			message = inFile.nextInt();
			packetnum = inFile.nextInt();
			packets = inFile.nextInt();
			data = inFile.nextLine();
		}
		if(message ==0)
		{
			p= null;
		}
		else
		{
			p = new Packet(message, packetnum, packets, data);
		}
		return  p;
	}
	
/***********************************************************************************
 * Method to return the Packet as a string
 * 
 * @return output the variables of a packet returned as a string 
 */
	public String toString()
	{
		String output="";
		output += String.format("%-4d", messageID);
		output += String.format("%6d", packetID);
		output += String.format("%6d", packetCount);
		output += String.format("%-30s", payload);
		return output;
	}
	
}
