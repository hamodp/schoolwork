
public class dogprint 
{
	public static void main (String [] arg)
	{
		Dog dog1 = new Dog("Coco", 3);
		Dog dog2 = new Dog("Buddy", 3);
		//dog name and age for the bios
		
		System.out.println("Coco's age:" + dog1.getDogage(3));
		System.out.println("Coco's human age:" + dog1.setHumanage(3));
	}
	
}
