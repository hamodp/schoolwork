/******************************************************************************
 * @filename: Name
 * @author: Patrick Hamod
 * @date: 16 Nov 2012
 *@version: 1
 * 
 * sets up name object to keep the age with respective name
 ******************************************************************************/
public class Name {

	String name;
	int age;
	
	Name(String n, int a){
		name=n;
		age =a;
	}
	
	//gets name from the object
	public String getName(){
		return name;
	}
	
	//used for comparing ages
	public String getAge(){
		if(age<10){
			String page ="0"+age;
			return page;
		}
		else{
			String page =""+age;
			return page;
		}
	}
}
