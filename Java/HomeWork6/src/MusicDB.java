/******************************************************************************
 * @filename: MusicDB
 * @author: Patrick Hamod
 * @date: 17 oct 2012
 *@version: 1
 * 
 * creates an arraylist of CDs that can add, find, remove and display the things in
 * the arraylist
 ******************************************************************************/
import java.util.ArrayList;


public class MusicDB {

	private int index=0;
	private static ArrayList db =new ArrayList(0);
	
	//adds a cd to the data base
	void add(MusicCD cd){
		db.add(cd);
		System.out.println();
	}
	
	//finds one cd and prints the relevant information
	void find(String title){
		for(index=0; index<db.size();index++){
			if(title.equalsIgnoreCase(((MusicCD) db.get(index)).getTitle())){
				System.out.println("Name of CD: "+ ((MusicCD)db.get(index)).getTitle());
				System.out.println("Name of group or artist: "+ ((MusicCD)db.get(index)).getName());
				System.out.println("Number of Tracks: "+ ((MusicCD)db.get(index)).getTracks());
				System.out.println("Copyright Year: "+((MusicCD)db.get(index)).getCopyright());
			}
			if(!title.equalsIgnoreCase(((MusicCD) db.get(index)).getTitle()))
				System.out.println("error CD not in Database");
			System.out.println();
			
		}
	}
	
	//displays all of the database information
	void display(){
		for(int a=0; a<db.size(); a++){
			System.out.println();
			System.out.println("Name of CD: "+ ((MusicCD)db.get(a)).getTitle());
			System.out.println("Name of group or artist: "+ ((MusicCD)db.get(a)).getName());
			System.out.println("Number of Tracks: "+ ((MusicCD)db.get(a)).getTracks());
			System.out.println("Copyright Year: "+((MusicCD)db.get(a)).getCopyright());
			System.out.println();
		}
	}
	
	//removes a cd and all components
	void remove(String remove){
		for(index = 0; index<db.size();index++){
			if(remove.equalsIgnoreCase(((MusicCD)db.get(index)).getTitle())){
				db.remove(index);
			}
		}
		System.out.println();
	}
}
