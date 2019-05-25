package diofantina;

public class Principal {

	public static void main(String[] args) {
		Euclides euclides = new Euclides();
		int mdc = euclides.calculoMdc(16, 24);
		System.out.println(mdc);
	}

}
