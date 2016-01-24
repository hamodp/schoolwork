import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Palindrome{

	static int a;
	static int z;
	static char[] word;
	static String input;
	
	
	public static boolean Palindromes(String in){
	
		input = in.toLowerCase();
		word = input.toCharArray();
		a = 0;
		z= word.length;
		if(word.length%2==0){
			while(a!=z && word[a]==word[z-1]){
				a++;
				z--;
				System.out.println(word[a]+" "+ word[z]);
			}
			if(word[a]==word[z-1]){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	
	
	
	public static void main (String[] args){
		
		boolean test;
		Scanner scan =new Scanner(System.in);
		char end=' ';
		while(end!='n'){
			System.out.println("Input the string that needs to be checked if it is a palindrome");
			System.out.println("(press n to terminate the program):\n");
			String in = scan.nextLine();
			test =Palindromes(in);
			end =  in.charAt(0);
			
			if(test){
				System.out.println("\r\nBINGO!! The entered input is a palindrome!");
				System.out.println();
			}
			else if(in.charAt(0)=='n'){
				break;
			}
			else{
				System.out.println("\nThe entered input is NOT a palindrome.\n");
			}
				
		}
		System.out.println("\nProcess Palindrome finished");
	}
}
