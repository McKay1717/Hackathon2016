import java.io.*;
import java.util.*;

class Polygon {
    
    int nbVertices; // nb sommets
    double[] x; // les coordonnées en x de chaque sommet
    double[] y; // les coordonnées en y de chaque sommet

    // autres attributs ???
    
    public Polygon() {
	// ???
    }

    /* readParameters():
       permet de lire avec scan les paramètres du polygone :
       le nombre de sommets suivi des coordonnées x et y de chacun
     */
    public void readParameters(Scanner scan) {

    }

    // autres méthodes ???
}

    
class PolyCenter {

    public static void main(String[] args) {
	Locale.setDefault(Locale.ENGLISH);
	
	Scanner scan = new Scanner(System.in);
	int nbPoly = scan.nextInt();
	
	for(int i=0;i<nbPoly;i++) {

	    Polygon p = new Polygon();
	    p.readParameters(scan);

	    /* A COMPLETER : (cf. sujet)

	       afficher sur la sortie standard le nombre
	       de sommets puis yes ou no selon que le centre du
	       polygone est à l'intérieur ou non.
	    */
	}
    }
}
