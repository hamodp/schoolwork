
public class RollingDice
{
	public static void main (String [] arg)
	{
		Die die1, die2;
		int sum;
		
		die1 = new Die();
		die2 = new Die();
		
		die1.roll();
		die2.roll();
		System.out.println("Die one:" + die1 +", Die two:" + die2);
		
		die1.roll();
		die2.setFaceValue(4);
		System.out.println("Die one:" + die1 + ", Die two:" + die2);
		
		sum = die1.getFaceValue() + die2.getFaceValue();
		System.out.println("Sum:" + sum);
		
		sum = die1.roll() + die2.roll();
		
	}
}
