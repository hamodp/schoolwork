import java.util.Scanner;

public class Encryptor {

	int letter=0;
	String alphabet;
	char[] order;
	
	Scanner scan = new Scanner(System.in);
	
	//creates an array of the alphabet
	Encryptor(){
		alphabet = "abcdefghijklmnopqrstuvwxyz ";
		order= alphabet.toCharArray();
	}
	
	//takes the character and replaces it withe the corresponding number of the key
	char encrypt(char key[], char msgChar[], char uchar){
		
		char secret[]=new char[msgChar.length];
		int index = (int)(uchar - 'a');
		secret[letter]=key[index];
		return secret[letter];
	}
	
	public static void main (String[] args){
		
		Encryptor enc = new Encryptor();
		
		Scanner scan = new Scanner(System.in);
		char[] key=new char[27];
		
		System.out.println("Enter the key as a random ordering of the 26 letters" +
				" of the English alphabet");
		
		//creates the key of the encryption
		for(int i =0; i<26; i++){
			System.out.print(i+ ": ");
			String input= scan.next();
			input.toLowerCase();
			key[i]=input.charAt(0);
			}
		key[26]=' ';
		
		scan.nextLine();
		String message = " ";
		
		//allows multiple messages to be emcrypted
		while(! message.equals("")){
			System.out.print("Enter the message to be encrypted: ");
			message = scan.nextLine();
			message.toLowerCase();
			char [] msgChar = message.toCharArray();
			System.out.print("The encrypted message is: ");
			
			//encrypts each letter of message
			for(int i=0; i<message.length(); i++){
				char uchar = msgChar[i];
				if(uchar !=' ')
					System.out.print(enc.encrypt(key, msgChar, uchar));
				else
					System.out.print(" ");
			}
			System.out.println();
			System.out.println();
		}
		
		System.out.print("Goodbye!");
	}
}
