/******************************************************************************
 * @filename: SoudEdit
 * @author: Patrick Hamod
 * @date: 29 oct 2012
 *@version: 1
 * 
 *takes a wav file and makes a low pass filter and echoed versions of the song
 ******************************************************************************/

public class SoundEdit {

	public static void main(String[] args) {
		
		// First, get the data from a sound file stored in .wav format.
		// Modify and use the following line if your .wav file is in a different folder
		// String fileName = "C:\\MyMusic\\iTunes\\BouncingSouls\\HopelessRomantic.wav";
		String fileName = "TokyoNena.wav";
		Sound sound1 = new Sound(fileName);
		Sound sound2 =new Sound(fileName);
		Sound sound3 =new Sound(fileName);
		
		
		// The following three lines get the value of a sound sample at
		// index 1000 and then set its value to half of the original. 
		int sum=0;
		int value;
		
		// The following loop sets every sound sample to be twice its original value
		for (int n=0; n < sound1.getNumSamples(); n++) {
			value = sound1.getSampleValueAt(n);
			sound1.setSampleValueAt(n, value);
		}
		
		//creates a low pass filter by taking the average of the next set
		//samples and sets it to the current sample
		for(int n=0; n<sound2.getNumSamples()-160; n++){
			for(int j=0; j<160; j++){
				sum = sum+ sound1.getSampleValueAt(n+j);
			}
			int avg =(int) sum/160;
			sound2.setSampleValueAt(n, avg);
			sum=0;
		}
		
		//creates an echo that plays with orignal
		for(int n=0; n<sound3.getNumSamples()-2000; n++){
			value = sound1.getSampleValueAt(n);
			int value2 = sound1.getSampleValueAt(n+2000);
			int value3= (int) ((value/2.0+ value2)/1.5);
			sound3.setSampleValueAt(n,value3);
		}

		// playes the three files original, low sound filter, and echo respectively
		sound1.blockingPlayOld();
		sound2.blockingPlayOld();
		sound3.blockingPlayOld();
		sound3.write("echo.wav");
		sound2.write("filtered.wav");
	}

}

