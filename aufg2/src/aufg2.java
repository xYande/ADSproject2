import java.util.Scanner;
import de.medieninf.ads.ADSTool;

/**
 * Algorithmus, welcher ein Paar (a,b) aus den Elementen
 * einer gegebenen sortierten Liste von
 * n natürlichen Zahlen sucht.
 * Dabei gilt x = a + b
 */
public class aufg2 {

    private static int a;
    private static int b;

    public static void main(String[] args){

        int [] zahlen = ADSTool.readIntArray("L.dat");
        System.out.println("Bitte geben sie eine Zahl ein: ");
        Scanner scan = new Scanner(System.in);
        int eingabe = scan.nextInt();
        sucher(zahlen, eingabe);
        System.out.println("a: " + a + " b: " + b + " = " + eingabe);
    }

    /**
     *  Such-Methode, welche auf die Rechner-Methode zugreift
     *  um das jeweilige Ergebnis auszugeben
     * @param zahlen Array an gegebenen Zahlen aus der L.dat
     * @param eingabe Eingabe an Zahlen vom Nutzer
     */
    public static void sucher(int [] zahlen, int eingabe){

        for (int i = 0; i < zahlen.length; i++){
            if(zahlen [i] > eingabe){
                rechner (zahlen, eingabe, i);
                return;
            }
        }
    }

    /**
     * Verrechnet die Eingabe beachtet dabei
     * @param zahlen Array an gegebenen Zahlen aus der L.dat
     * @param eingabe Eingabe an Zahlen vom Nutzer
     * @param gross Entspricht der jeweilig größeren Zahl
     */
    public static void rechner(int [] zahlen, int eingabe, int gross) {
        int klein = 0;
        while (klein < gross) {
            if (zahlen[gross] + zahlen[klein] == eingabe) {
                a = klein + 1;
                b = gross + 1;
                return;
            } else if (zahlen[gross] + zahlen[klein] >= eingabe) {
                gross--;
            } else if (zahlen[gross] + zahlen[klein] <= eingabe) {
                klein++;
            }
        }
    }
}

