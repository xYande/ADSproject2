package A1;
import de.medieninf.ads.ADSTool;

public class A1 {
    public static void main (String [] args) {
        PriorityListing listing = new PriorityListing();
        String[] words = ADSTool.readStringArray("words.dat");

        for (String word : words) {
            listing.insert(word);
        }

        for (int i = 0; i < words.length; i++) {
            System.out.println(listing.min());
            listing.getMin();
        }
    }
}
