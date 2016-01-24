// import java.util.TreeMap;
import java.util.Scanner;

public interface IPacketAssembler
{
//
// <code>dumpMessage</code> basically does a toString of an individual
//       message given the ID of the message
// <code>readPacket</code> does more than just read packets
//       if the packet is the first packet for a new message, it must
//       create a new ArrayList<Packet>, add this first packet to the
//       list, and then add the list to the message list
// you will probably want the other two private methods as helpers
//

//  private Packet addPacket(int messageIndex, Packet p);

  public String dumpMessage(int messageID);

//  

  public int readPacket(Scanner inFile);

} // public interface PacketAssembler
