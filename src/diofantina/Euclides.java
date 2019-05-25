package diofantina;

public class Euclides {

	public int calculoMdc(int a, int b) {
		int q, r, mdc, aux = 0;
		if (b > a) {
			aux = a;
			a = b;
			b = aux;
		}
		do {
			q = a / b;
			r = a % b;
			a = b;
			b = r;
		} while (r != 0);
		mdc = a;
		return mdc;
	}
}
