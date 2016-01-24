/*******************************************************
*@filename: BankAccount
*@author: Patrick Hamod
*@version: 1
*@date: 26 Sept 2012
*
*creates an account for a player to bet in the gamble class
**********************************************************/
public class BankAccount 
{
	private String owner;
	private double balance;
	private double bet;
	
	BankAccount(String name){
		String owner = name;
		balance = 1000;
	}
	
	
	//calculates the money lost in the wager
	double loss(double wager){
		balance-=wager;
		return balance;
	}
	
	//calculates the money won
	double Win(double wager){
		balance+=wager;
		return balance;
	}
	
	// returns money left in the accounts
	double getBalance(){
		return balance;
	}
}
