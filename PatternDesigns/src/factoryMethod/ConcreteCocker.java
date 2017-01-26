package factoryMethod;

public class ConcreteCocker implements Product{
	int size;
	
	@Override
	public void ladrar() {
		System.out.println("Cocker");
	}

	@Override
	public void morder() {
		System.out.println("Mordida de Cocker");
	}
	
	//We can augment the interface also, Product interface just serve as my basis
		public int getSize() {
			return size;
		}
}
