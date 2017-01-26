package factoryMethod;

public class ConcreteDoberman implements Product {

	int size;
	
	@Override
	public void ladrar() {
		System.out.println("Doberman");
	}

	@Override
	public void morder() {
		System.out.println("MegaMordida");
	}
	
	//We can augment the interface also, Product interface just serve as my basis
		public int getSize() {
			return size;
		}
}
