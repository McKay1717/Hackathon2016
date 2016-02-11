import java.io.*;
import java.util.*;

/* UTILISATION :
   - Pour compiler : javac ToBits.java
   - Pour lancer le programme avec les fichiers de test fourni : 
       java ToBits <02_3values.in >result.txt

   - Ensuite vous pouvez comparer chaque résultat avec l'attendu :
      diff result.txt 02_3values.ans

    Si la commande n'affiche aucune différence, votre programme fonctionne à priori correctement et vous
    pouvez le soumettre.          

*/
class Value {

    byte[] bits;
    
    public Value(int value) {
	bits = new byte[32];
	for(int i=0;i<32;i++) bits[i] = 0;
	convertToBits(value);
    }

    public int msb() {
    }

    public int nbOnes() {
    }

    private void convertToBits(int value) {	
    }
}

    
class ToBits {    

    public static void main(String[] args) {
	Locale.setDefault(Locale.ENGLISH);
	
	Scanner scan = new Scanner(System.in);

	/* A COMPLETER
	   - lire le nombre de valeurs à traiter
	   - pour chaque valeur, la lire et instancier la classe Value
	   - utilser l'instance pour afficher la position du bit de
	   poids fort (à partir de 0) suivi  du nombre de bits à 1.
	 */
	}
    }
}
