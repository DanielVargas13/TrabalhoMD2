package diofantina;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Euclides {

	private ArrayList<Parcial> partes;

	public Euclides() {

		partes = new ArrayList<Parcial>();

	}

	public void calculoMdc(int a, int b) {

		int q, r, aux = 0;
		Parcial p;

		if (b > a) {
			aux = a;
			a = b;
			b = aux;
		}
		do {
			p = new Parcial();
			q = a / b;
			r = a % b;
			p.setR(r);
			p.setA(a);
			p.setB(b);
			p.setX(1);
			p.setY(-q);
			partes.add(p);
			a = b;
			b = r;
		} while (r != 0);

	}

	public Parcial reversao(int a, int b, int c) {
		calculoMdc(a, b);
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
				int aux = inicial.getX();
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

	public LinkedHashMap<Integer, Integer> calcularSolucoes(Parcial inicial) {
		double t1, t2;
		int rt1, rt2;
		int x;
		int y;
		LinkedHashMap<Integer, Integer> solucoes = new LinkedHashMap<Integer, Integer>();
		t1 = -inicial.getX() / (inicial.getB() / inicial.getR());
		rt1 = -inicial.getX() % (inicial.getB() / inicial.getR());
		t2 = inicial.getY() / (inicial.getA() / inicial.getR());
		rt2 = inicial.getY() % (inicial.getA() / inicial.getR());
		if (rt1 == 0) {
			t1++;
		}
		if (rt2 != 0) {
			t2++;
		}
		for (int i = (int) t1; i < t2; i++) {
			x = inicial.getX() + (inicial.getB() / inicial.getR()) * i;
			y = inicial.getY() - (inicial.getA() / inicial.getR()) * i;
			solucoes.put(x, y);
		}
		return solucoes;
	}
}
