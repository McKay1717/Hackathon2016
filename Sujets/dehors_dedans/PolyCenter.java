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

	public boolean pointInPolygon(double x, double y) {
		int i, j = this.nbVertices - 1;
		boolean oddNodes = false;

		for (i = 0; i < this.nbVertices; i++) {
			if (this.y[i] < y && this.y[j] >= y || this.y[j] < y
					&& this.y[i] >= y) {
				if (this.x[i] + (y - this.y[i]) / (this.y[j] - this.y[i])
						* (this.x[j] - this.x[i]) < x) {
					oddNodes = !oddNodes;
				}
			}
			j = i;
		}

		return oddNodes;
	}

	public double BarycentreX() {
		double X = 0;
		for (int i = 0; i < x.length; i++) {
			X += x[i];
		}

		return (double) X / (double) x.length;
	}

	public double BarycentreY() {
		double Y = 0;
		for (int i = 0; i < y.length; i++) {
			Y += y[i];
		}

		return (double) Y / (double) y.length;
	}

	public boolean isInArea(double X, double Y) {

		return this.pointInPolygon(X, Y);

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
