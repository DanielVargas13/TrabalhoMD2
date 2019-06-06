package diofantina;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Euclides {

	private ArrayList<Parcial> partes;

	public Euclides() {

		partes = new ArrayList<Parcial>();

	}

	public Parcial aplicarEuclides(int a, int b, int c) {
		int a1 = a, b1 = b, q = 0, r = 0, aux = 0;
		Parcial p;

		if (b1 > a1) {
			aux = a1;
			a1 = b1;
			b1 = aux;
		}
		do {
			p = new Parcial();
			q = a1 / b1;
			r = a1 % b1;
			p.setR(r);
			p.setA(a1);
			p.setB(b1);
			p.setX(1);
			p.setY(-q);
			partes.add(p);
			a1 = b1;
			b1 = r;
		} while (r != 0);

		int tam = 0;
		if (partes.size() > 2) {
			tam = partes.size() - 2;
		}
		Parcial inicial = partes.get(tam);
		if (inicial.getR() != 0 && (c % inicial.getR() == 0)) {

			Parcial atual = null;
			for (int i = tam - 1; i >= 0; i--) {

				atual = partes.get(i);
				atual.setR(inicial.getR());
				atual.setX(atual.getX() * inicial.getY());
				atual.setY(atual.getY() * inicial.getY());
				atual.setY(atual.getY() + inicial.getX());
				inicial = atual;
			}
			if (inicial.getA() != a) {

				inicial.setA(b);
				inicial.setB(a);
				aux = inicial.getX();
				inicial.setX(inicial.getY());
				inicial.setY(aux);

			}
			inicial.setX(inicial.getX() * (c / inicial.getR()));
			inicial.setY(inicial.getY() * (c / inicial.getR()));

		} else {
			inicial = null;
		}
		return inicial;
	}

	public LinkedHashMap<Integer, Integer> obterSolucoes(Parcial inicial) {
		double t1, t2;
		int rt1;
		int x;
		int y;
		LinkedHashMap<Integer, Integer> solucoes = new LinkedHashMap<Integer, Integer>();
		t1 = (double) -inicial.getX() / (double) (inicial.getB() / inicial.getR());
		rt1 = -inicial.getX() % (inicial.getB() / inicial.getR());
		t2 = (double) inicial.getY() / (double) (inicial.getA() / inicial.getR());
		if (rt1 == 0) {
			t1++;
		}

		for (int i = (int) t1; i < t2; i++) {
			x = inicial.getX() + (inicial.getB() / inicial.getR()) * i;
			y = inicial.getY() - (inicial.getA() / inicial.getR()) * i;
			solucoes.put(x, y);
		}
		return solucoes;
	}
}
