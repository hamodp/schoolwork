import java.util.Scanner;

/*********************************************************************
 * Interface for 'Packet' for handling a packet.
 * @author Duncan Buell
**/
public interface IPacket
{
//  private int messageID;
//  private int packetID;
//  private int packetCount; // number of packets in this message
//  private String payload;

  public int compareTo(Packet p);

  public boolean equals(Object p);

  public int getMessageID();

  public int getPacketID();

  public int getPacketCount();

  public String getPayload();

  public Packet readPacket(Scanner inFile);

  public String toString();

} // public interface IPacket
