package factoryMethod;

public class test {
	public static void main(String []args){
		/**Create some dogs*/
		Product dog = Creator.getSpecificDog("small");
		//Poodle
		dog.ladrar();
		/**Create a different dog using same constructing class*/
		Product dog2 = Creator.getSpecificDog("medium");
		//Cocker
		dog2.ladrar();
		/**In this way, we delegate construction*/
		dog2 = Creator.getSpecificDog("big");
		//Doberman
		System.out.println("Now I am a:");
		dog2.ladrar();
	}
}
