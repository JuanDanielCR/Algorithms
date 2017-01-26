package factoryMethod;

public class ConcretePoddle implements Product{
	int size;
	
	@Override
	public void ladrar() {
		System.out.println("Poodle");		
	}
	@Override
	public void morder() {
		System.out.println("No puedo morder");
	}
	
	//We can augment the interface also, Product interface just serve as my basis
	public int getSize() {
		return size;
	}
}
