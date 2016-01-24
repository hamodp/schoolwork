import java.util.ArrayList;
import java.util.Scanner;


public class PacketAssembler implements IPacketAssembler{

	private int messageID;
	private ArrayList<ArrayList<Packet>> messages;
	
	public PacketAssembler()
	{
		messages = new ArrayList<ArrayList<Packet>>();
	}
	
	public String dumpMessage(int messageID) 
	{
		String output ="";
		
		return output;
	}

	public int readPacket(Scanner inFile) 
	{
		ArrayList<Packet> message = new ArrayList<Packet>();
		Packet incoming;
		Scanner scan;
		while(inFile.hasNext())
		{
			incoming = new Packet();
			scan =new Scanner(inFile.nextLine());
			incoming = incoming.readPacket(scan);
			messageID = incoming.getMessageID();
			if(message.isEmpty() || messageID == incoming.getMessageID())
			{
				messageID = incoming.getMessageID();
				System.out.println(incoming);
				message.add(incoming);
			}
		}
		return 0;
	}

}
