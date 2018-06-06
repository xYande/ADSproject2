import de.medieninf.ads.ADSTool;

    /**
     * Ein Programm welches eine unsortierte Liste an Wörtern
     * durch unsere Implementierung anschließend sortiert
     * nach Wortlänge ausgibt.
     * @author Alexander Bopp, Felix Fuhrmann, Lisa-Marie Kaiser
     */
    public class aufg1 {
        public static void main (String [] args) {
            PriorityListing listing = new PriorityListing();
            String[] words = ADSTool.readStringArray("words.dat");

            // Schleife, welche jedes Word-Element in die LinkedList einfügtt
            for (String word : words) {
                listing.insert(word);
            }

            // String Array words wird durch iteriert und jeweils
            // durch min() das Element mit dem kleinsten Schlüssel ausgegeben
            for (int i = 0; i < words.length; i++) {
                System.out.println(listing.min());
                listing.getMin();
            }
        }
    }
