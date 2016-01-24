
import java.io.*;

/******************************************************************************
 * @filename: TowerRecords
 * @author: Patrick Hamod
 * @date: 23 oct 2012
 *@version: 1
 * 
 * Takes a txt file of the inventory and creates a new txt file with updated prices
 ******************************************************************************/
public class TowerRecords {
	
	public static void main(String[] args)throws IOException{
		
		//albums is the number of different records in the inventory txt file
		int albums = 5;
		final int CURRENTYEAR = 2012;
		
		//reads the original txt file
		FileReader fr = new FileReader("inventory.txt");
		BufferedReader scan = new BufferedReader(fr);
		
		//creates a txt file with new prices
		FileWriter change = new FileWriter("newPrices.txt");
		
		//goes through four lines of code  
		for(int i =0; i<=albums; i++){
				
		//takes the album from first file to the second
		
			String CD ="Album: "+ scan.readLine()+"\r\n";
			change.write(CD);
		
		
			//takes the artist to the new file
			String artist = "Artist: "+scan.readLine()+"\r\n";
			change.write(artist);
			
			//writes the year the CD was made
			String release = scan.readLine();
			change.write("Year released: "+release+"\r\n");
			
			int year = Integer.parseInt(release);
			String price = scan.readLine();
			
			//if the cd less than 5 years and at least 1 year old reduce price by 5%
			if(CURRENTYEAR - year<5 && CURRENTYEAR - year>=1){
				price = price.substring(1);
				double cost = Double.parseDouble(price);
				cost= cost*19/20;
				change.write("Price: $"+cost+"\r\n");
			}
			
			//if cd is less than 10 years but at least 5years old reduce by 10%
			else if(CURRENTYEAR - year<10 && CURRENTYEAR - year>=5){
				price = price.substring(1);
				double cost = Double.parseDouble(price);
				cost= cost*9/10;
				change.write("Price: $"+cost+"\r\n");
			}
			
			//if older than 10 years reduce by 50%
			else if(CURRENTYEAR - year>=10){
				price = price.substring(1);
				double cost = Double.parseDouble(price);
				cost= cost*1/2;
				change.write("Price: $"+cost+"\r\n");
			}
			
			else{
				change.write("Price: "+price+"\r\n");
			}
			change.write("\r\n");
		
		}
		scan.close();
		change.close();
	}
}
