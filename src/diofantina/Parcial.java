package diofantina;

public class Parcial {
	
	private int r, a, x, b, y;
	
	public Parcial() {
		
	}
	
	public Parcial(int r, int a, int x, int b, int y) {
		setR(r);
		setA(a);
		setX(x);
		setB(b);
		setY(y);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Parcial [r=" + r + ", a=" + a + ", x=" + x + ", b=" + b + ", y=" + y + "]";
	}
	

}
