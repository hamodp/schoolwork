/******************************************************************************
 * @filename: TestMusicDB
 * @author: Patrick Hamod
 * @date: 17 oct 2012
 *@version: 1
 * 
 * tests the MusicDB program and allows for a temporary creation of a database
 * allowing user to add CDs, find them, remove them, and display all of them in the
 *  database.
 ******************************************************************************/
import java.util.Scanner;

public class TestMusciDB {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		MusicDB db = new MusicDB();
		char command=' ';
		
		System.out.println("Welcome to your personal music database. The legal commands are");
		System.out.println("q for quit");
		System.out.println("d for display");
		System.out.println("a for add");
		System.out.println("f for find");
		System.out.println("r for remove");
		System.out.println();
		
		
		while(command!= 'q'){
			
			System.out.println("What is your command?");
			String input = scan.next();
			command = input.charAt(0);		
			scan.nextLine();
			
			//creates new cd for the database
			if(command=='a'){
				
				System.out.println();
				
				MusicCD cd = new MusicCD();
				System.out.print("Name of CD: ");
				String Title = scan.nextLine(); 
				cd.setTitle(Title);
				
				System.out.print("Name of group or artist: ");
				cd.setName(scan.nextLine());
				
				
				System.out.print("Number of tracks: ");
				cd.setTracks(scan.nextInt());
				
				System.out.print("Copyright year: ");
				cd.setCopyright(scan.nextInt());
				
				db.add(cd);
			}
			
			//displays all cds in the database
			else if(command=='d'){
				db.display();
			}
			
			//implements the find metthod to find the cd and its information
			else if(command == 'f'){
				System.out.println();
				System.out.print("Please enter CD title: ");
				
				String find = scan.nextLine();
				db.find(find);
			}
			
			//removes a cd and its information
			else if(command == 'r'){
				System.out.println();
				System.out.println("Pleae enter CD title: ");
				
				String remove = scan.nextLine();
				db.remove(remove);
			}
			
			//ends the program
			else if(command == 'q'){
				System.out.println();
				System.out.println("Goodbye!");
			}
			else
				System.out.println("please enter a valid command");
			
		}
	}
}
