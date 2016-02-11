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

		return X / x.length;
	}

	public double BarycentreY() {
		double Y = 0;
		for (int i = 0; i < y.length; i++) {
			Y += y[i];
		}

		return Y / y.length;
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

		System.err.println("Donner le polygone de format : nbSommets x1 y1 x2 y2 ... xn yn");

		String[] split = scan.next().split(" ");

		this.nbVertices = Integer.parseInt(split[0]);

		for(int i = 0; i < this.nbVertices; i++)
		{
			this.x[i] = Double.parseDouble(split[i*2+1]);
			this.y[i] = Double.parseDouble(split[i*2+2]);
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

			/*
			 * A COMPLETER : (cf. sujet)
			 * 
			 * afficher sur la sortie standard le nombre de sommets puis yes ou
			 * no selon que le centre du polygone est à l'intérieur ou non.
			 */
		}
	}
}
