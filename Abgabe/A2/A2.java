import java.util.Scanner;
import de.medieninf.ads.ADSTool;

public class A2 {

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

    public static void sucher(int [] zahlen, int eingabe){

        for (int i = 0; i < zahlen.length; i++){
            if(zahlen [i] > eingabe){
                rechner (zahlen, eingabe, i);
                return;
            }
        }
    }

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
