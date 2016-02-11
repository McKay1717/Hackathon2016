import java.util.Locale;
import java.util.Scanner;

class Polygon {

	int nbVertices; // nb sommets
	double[] x; // les coordonnées en x de chaque sommet
	double[] y; // les coordonnées en y de chaque sommet

	// autres attributs ???

	public Polygon() {
		// ???
	}

	public double BarycentreX() {
		double X = 0;
		for (int i = 0; i < x.length; i++) {
			X += x[i];
		}

		return (double)X / (double)x.length;
	}

	public double BarycentreY() {
		double Y = 0;
		for (int i = 0; i < y.length; i++) {
			Y += y[i];
		}

		return (double)Y / (double)y.length;
	}

	public boolean isInArea(double X, double Y) {
		double maxX = 0;
		double maxY = 0;
		double minX = 0;
		double minY = 0;
		for (int i = 0; i < this.x.length; i++) {
			if (x[i] >= maxX) {
				maxX = x[i];
			}
			if (y[i] >= maxY) {
				maxY = y[i];
			}
			if (x[i] <= minX) {
				maxX = x[i];
			}
			if (y[i] <= minY) {
				minY = y[i];
			}
		}

		return X >= minX && X <= maxX && Y >= minY && Y <= maxY;

	}

	/*
	 * readParameters(): permet de lire avec scan les paramètres du polygone :
	 * le nombre de sommets suivi des coordonnées x et y de chacun
	 */
	public void readParameters(Scanner scan) {

		this.nbVertices = scan.nextInt();
		this.x = new double[this.nbVertices];
		this.y = new double[this.nbVertices];

		for (int i = 0; i < this.nbVertices; i++) {
			this.x[i] = scan.nextDouble();
			this.y[i] = scan.nextDouble();
		}

	}

	// autres méthodes ???
}

class PolyCenter {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		Scanner scan = new Scanner(System.in);
		int nbPoly = scan.nextInt();

		for (int i = 0; i < nbPoly; i++) {
			Polygon p = new Polygon();
			p.readParameters(scan);
			if (p.isInArea(p.BarycentreX(), p.BarycentreY())) {
				System.out.println(p.nbVertices + " yes");
			} else {
				System.out.println(p.nbVertices + " no");
			}

		}
	}
}
