package factoryMethod;

//Building class
public class Creator{
	//Sometimes this is an abstract method, delegate construction to subclasses.
	//Method is always static
	public static Product getSpecificDog(String size){
		if(size.equals("small")) return new ConcretePoddle();
		else if(size.equals("big")) return new ConcreteDoberman();
		else if(size.equals("medium"))return new ConcreteCocker();
		return null;
	}
}
