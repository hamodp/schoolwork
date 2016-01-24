
public class MusicCD {

	private String title;
	/******************************************************************************
	 * @filename: MusicCD
	 * @author: Patrick Hamod
	 * @date: 17 oct 2012
	 *@version: 1
	 * 
	 * Creates CD object with the name, the artist, the number of tracks and the
	 * copyright year
	 ******************************************************************************/
	private String name;
	private int tracks;
	private int copyright;
	
	MusicCD(){
		title = "";
		name = "";
		tracks=0;
		copyright = 0;
	}
	
	//sets the title of the cd
	void setTitle(String CD){
		title = CD;
	}
	
	// returns the name of the cd
	String getTitle(){
		return title;
	}
	
	//sets the name of the band
	void setName(String band){
		name = band;
	}
	
	//returns the name of the band
	String getName(){
		return name;
	}
	
	//sets the number of tracks on CD
	void setTracks(int tracks){
		this.tracks = tracks;
	}
	
	//returns the number of tracks
	int getTracks(){
		return tracks;
	}
	
	//sets the year of publication
	void setCopyright(int year){
		copyright = year;
	}
	
	//returns the year of publication
	int getCopyright(){
		return copyright;
	}
}
