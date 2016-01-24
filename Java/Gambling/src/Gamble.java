/*******************************************************
*@filename: Gamble
*@author: Patrick Hamod
*@version: 1
*@date: 26 Sept 2012
*
*program takes user input of name and the money they wager 
*in a game where if they roll a 7 they win
**********************************************************/
import java.util.*;



public class Gamble {
	public static void main(String[] args){
		
		//prints the rules of the game
		System.out.println("\t Lucky 7");
		System.out.println("Rules: inorder for a player to win he/ she must roll a seven if the player");
		System.out.println("fails to roll a seven the money goes to the house.");
		
		//allows players to input their names
		Scanner scan = new Scanner(System.in);
		
		//makes player and the money they would like to wager
		System.out.print("please enter player's name: ");
		String player1= scan.next();
		System.out.print("please entter the amount you would like to wager: ");
		double wager1 = scan.nextDouble();
		
		//wager must be below 1000
		while(wager1 > 1000){
			System.out.print(player1 + "is trying to cheat the highest wager is 1000");
			wager1 = scan.nextDouble();
		}
		
		//makes player 2 and the money they will wager
		System.out.print("please enter another player to start: ");
		String player2 = scan.next();
		System.out.print("please enter the amount you would like to wager: ");
		double wager2 = scan.nextDouble();
		
		//wager must be below 1000
		while(wager1 > 1000){
			System.out.print(player2 + "is trying to cheat the highest wager is 1000");
			wager1 = scan.nextDouble();
		}
		
		
		//makes the players their accounts
		BankAccount p1 = new BankAccount(player1);
		BankAccount p2 = new BankAccount(player2);
		
		//keeps going until a player runs out of money
		while(p1.getBalance() > 0 && p2.getBalance() > 0){
			Die roll1 = new Die();
			Die roll2 = new Die();
			
			//player 1 turn to roll dice 
			if(roll1.getValue()+roll2.getValue() == 7){
				 p1.Win(wager1);
				 System.out.println(player1 + " has won.");
			}
			else{
				p1.loss(wager1);
				System.out.println(player1 + " has lost.");
			}
			roll1.display( 50, 50);
			roll2.display(100, 100);
			System.out.println("remaining money: " + p1.getBalance());
			
			Die roll3 = new Die();
			Die roll4 = new Die();
			//player two turn to roll dice
			if(roll3.getValue() + roll4.getValue()  == 4){
				p2.Win(wager2);
				System.out.println(player2 + " has won.");
			}
			else{
				p2.loss(wager2);
				System.out.println(player2 + " has lost.");
			}
			roll3.display(150,150);
			roll4.display(200,200);
			System.out.println("remaining money: " + p2.getBalance());
		}
		
		//displays the loser and the winner with the money the winner has they
		if(p2.getBalance()>0){
			System.out.println(player2 + " wins with: "+ p2.getBalance());
			System.out.println(player1 + " has lost");
		}
		else{
			System.out.println(player1 + " wins with: "+ p1.getBalance());
			System.out.println(player2 + " has lost");
		}
	}
}