import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by cladlink on 11/02/16.
 */
public class Farpaitement
{
    public static Scanner input = new Scanner(System.in);

    /**
     * Test si un nombre est parfait
     *
     * @param n
     * @return
     */
    public static int parfait(int n)
    {
        int somme = 0;
        for(int i = 1; i <= n / 2; i++)
        {
            if(n % i == 0)
            {
                somme += i;
            }
        }
        if(somme != n)
            return 0;
        else
            return 1;

    }

    /**
     * test si un nombre est triangulaire
     *
     * @param n
     * @return
     */
    public static int triangulaire(int n)
    {
        int somme = 0;
        for(int i = 1; i <= n; i++)
        {
            somme += i;
            if(somme == n)
            {
                return 1;
            }
        }
        return 0;
    }

    /**
     * test si la somme de cube des impairs successifs mene au chiffre donné
     *
     * @param n
     * @return
     */
    public static int sommeCubeImpair(int n)
    {
        int somme = 0;
        for(int i = 0; i < n / 2; i++)
        {
            if(i % 2 == 1)
                somme += Math.pow(i, 3);
            if(somme == n)
                return 1;
        }
        return 0;
    }

    /**
     * test si la moitié gauche du chiffre + la moitié droite est égale à la racine carré de n
     *
     * @param n
     * @return
     */
    public static int kaprekarDix(int n)
    {
        String nToString = Integer.toString((int) Math.pow(n, 2));

        int nb1, nb2;
        String Snb1, Snb2;
        int retour = 0;
        for(int i = 0; i < nToString.length() - 1; i++)
        {
            Snb1 = "";
            Snb2 = "";

            for(int j = 0; j <= i; j++)
            {
                Snb1 += nToString.charAt(j);
            }
            nb1 = Integer.parseInt(Snb1);

            for(int j = i + 1; j < nToString.length(); j++)
            {
                Snb2 += nToString.charAt(j);
            }
            nb2 = Integer.parseInt(Snb2);

            if(n == (nb1 + nb2))
            {
                retour = 1;
            }
        }
        return retour;
    }


    public static int kaprekarDeux(int n)
    {
        int carre = (int) Math.pow(n, 2);

        String nToString = Integer.toString(carre, 2);

        int nb1, nb2;
        String Snb1, Snb2;
        int retour = 0;
        for(int i = 0; i < nToString.length() - 1; i++)
        {
            Snb1 = "";
            Snb2 = "";

            for(int j = 0; j <= i; j++)
            {
                Snb1 += nToString.charAt(j);
            }
            nb1 = Integer.parseInt(Snb1, 2);

            for(int j = i + 1; j < nToString.length(); j++)
            {
                Snb2 += nToString.charAt(j);
            }
            nb2 = Integer.parseInt(Snb2, 2);

            /*System.err.println(carre + "\t" + nToString);
            System.err.println("Snb1 " + Snb1 + "\t Snb1 " + Snb2);
            System.err.println("nb1 " + nb1 + "\t Snb1 " + nb2);
            System.err.println();*/

            if(n == (nb1 + nb2))
            {
                retour = 1;
            }
        }

        return retour;

    }

    /**
     * test si nombre parfait pair
     *
     * @param args
     */
    public static void main(String[] args)
    {
        int parfait;
        int kaprekarDeux;
        int scp;
        int triang;
        int kaprekarDix;
        int n, i, m;

        m = input.nextInt();

        for(i = 0; i < m; i++)
        {
            n = input.nextInt();

            parfait = parfait(n);
            triang = triangulaire(n);
            scp = sommeCubeImpair(n);
            kaprekarDix = kaprekarDix(n);
            kaprekarDeux = kaprekarDeux(n);

            System.out.println(parfait + " " + triang + " " + scp + " " + kaprekarDix + " " + kaprekarDeux);
        }
    }

}
