import java.util.*;

/* IMPORTANT : seule classe Board est à modifier..
*/

/* UTILISATION :
   - Pour compiler : javac Tetris1.java
   - Pour lancer le programme avec les fichiers de test fourni, par exemple : 
       java Tetris <013_4x3sample.in >result.txt

   - Ensuite vous pouvez comparer chaque résultat avec l'attendu :
      diff result.txt 013_4x3sample.ans

    Si la commande n'affiche aucune différence, votre programme fonctionne à priori correctement et vous
    pouvez le soumettre.          

*/

abstract class Form {
    protected static int count = 0;
    /* NOTE : 
       chaque forme est décrite en spécifiant les cases qu'elle occupe
       dans sa boite englobante. Dans le problème Tetris, on considère
       qu'une forme occupe au maximum 6 cases (cf. Hook).
       Chaque case occupée a des coordonnées (i,j) qui sont mises dans les tableaux
       x et y, avec x l'abscisse et y l'ordonnée orientée vers le bas.

       Par exemple: la forme ci-dessous
       ###
       #
       occupe 4 cases dans sa boite englobante aux coordonnées (0,0) (1,0), (2,0) et (1,0). 
       Il y a donc 4 couples mis dans x[], y[]  (peut importe leur ordre) :
       x[0] = 0, y[0] = 0
       x[1] = 1, y[1] = 0
       x[2] = 2, y[2] = 0
       x[3] = 0, y[3] = 1
       
    */
    byte[] x;
    byte[] y;
    int id; // a unique id among all instaces of form
    int volume;

    public Form() {
	x = new byte[6];
	y = new byte[6];
        count += 1;
        id = count;
        volume = 0;
    }

    public String toString() {
	return getClassName()+" - "+id;
    }

    public abstract String getClassName();
}

class Rect extends Form {

    /* Forme : 
       ##
       => coordonnées : (0,0) (1,0)
     */
    public Rect() {
        super();
	x[0] = 0; y[0] = 0;
	x[1] = 1; y[1] = 0;
        volume = 2;
    }

    public String getClassName() {
        return "Rect";
    }
}

class Corner extends Form {
    
    /* Forme : 
        #
       ##
       => coordonnées : (1,0) (1,0) (1,1)
     */

    public Corner() {
        super();
	x[0] = 1; y[0] = 0;
	x[1] = 0; y[1] = 1;
	x[2] = 1; y[2] = 1;
        volume = 3;
    }

    public String getClassName() {
        return "Corner";
    }
}

class Elle extends Form {

    /* Forme : 
       #
       #
       ##
       => coordonnées : (0,0) (0,1) (0,2) (1,2)
     */
    
    public Elle() {
        super();
	x[0] = 0; y[0] = 0;
	x[1] = 0; y[1] = 1;
	x[2] = 0; y[2] = 2;
	x[3] = 1; y[3] = 2;
        volume = 4;
    }

    public String getClassName() {
        return "L";
    }
}


class Cross extends Form {

    /* Forme : 
        #
       ###
        #
       => coordonnées : (1,0) (0,1) (1,1) (2,1) (1,2)
     */

    public Cross() {
        super();
	x[0] = 1; y[0] = 0;
	x[1] = 0; y[1] = 1;
	x[2] = 1; y[2] = 1;
	x[3] = 2; y[3] = 1;
	x[4] = 1; y[4] = 2;
        volume = 5;
    }

    public String getClassName() {
        return "Cross";
    }
}

class Hook extends Form {
    /* Forme : 
       ###
       # #
       #
       => coordonnées : (0,0) (1,0) (2,0) (0,1) (2,1) (0,2)
     */

    public Hook() {
        super();
	x[0] = 0; y[0] = 0;
	x[1] = 1; y[1] = 0;
	x[2] = 2; y[2] = 0;
	x[3] = 0; y[3] = 1;
	x[4] = 2; y[4] = 1;
	x[5] = 0; y[5] = 2;	
        volume = 6;
    }

    public String getClassName() {
        return "Hook";
    }
}

class Board {

    int[][] board;
    int width;
    int height;
    int volume; // volume du placement actuellement en cours d'évaluation
    int bestVolume; // meilleur volume occupé trouvé
    int nbBest; // nb de placements optimaux
    List<Form> forms;

    public Board() {
	width = 0;
	height = 0;
	volume = 0;
	bestVolume = 0;
	nbBest = 0;
	forms = new ArrayList<Form>();
    }

    public void readParameters(Scanner scan) {

	/* A COMPLETER :
	   - lire la largeur puis hauteur
	   - instancier board et le remplir avec des 0.
	   - lire le nombre X de formes
	   - lire X numéro de forme, les instancier et les mettre dans forms
	 */
    }

    public boolean putForm(Form f, int x, int y) {

	/* A COMPLETER :

	   - test si possible de placer f en x,y (x = pos. largeur et y = pos. hauteur)
	   - si pas possible (i.e. chevauchement, débordement extérieur), renvoyer false,
	   - si possible, mettre à 1 les cases de board occupées par la forme.
	   - renvoyer true

	   Rq : x,y correspond au coin supérieur gauche de la boite englobante de f. Donc
	   si f est une instance de Corner à placer en (1,2), alors ce seront les cases (2,2) (1,3) et (2,3)
	   qui seront occupées
	 */
    }

    public void removeForm(Form f, int x, int y) {

	/* A COMPLETER :

	   - enlever f de board, en supposant qu'elle est en x,y (x = pos. largeur et y = pos. hauteur)

	   Rq : x,y correspond au coin supérieur gauche de la boite englobante de f. Donc
	   si f est une instance de Corner à enlever de (1,2), alors ce seront les cases (2,2) (1,3) et (2,3)
	   qui seront remises à 0.

	 */
    }

    public void place() {

	/* A COMPLETER :

	   Rq : place() permet d'initialiser la récursion. Elle va donc appeler placeRecur()

	 */
    }

    public void placeRecur(/* A COMPLETER */) {

	/* A COMPLETER

	 */
    }
}

class Tetris1 {

    public static void main(String[] args) {
	
	Locale.setDefault(Locale.ENGLISH);
	
	Scanner scan = new Scanner(System.in);
	Board b = new Board();
	b.readParameters(scan);
	b.place();
	System.out.println(b.bestVolume+" "+b.nbBest);
    }
}
