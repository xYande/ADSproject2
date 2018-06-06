import java.util.LinkedList;

public class PriorityListing {

    private LinkedList<String> listing = new LinkedList<>();

    /**
     * Fügt das Element x in die Warteschlange ein
     * @param x Wort der einzulesenden Datei
     */
    public int insert (String x) {
        if (listing.isEmpty()) {
            listing.add(x);
        } else {
            int position = 0;
            for (int i = 0; i < listing.size(); i++) {
                if (x.length() > listing.get(i).length()) {
                    position++;
                }
            }
            listing.add(position, x);
        }
        return 0;
    }

    /**
     * Gibt das Element mit dem kleinsten Schlüssel (d.h. mit der höchsten Priorität)
     aus der Warteschlange zurück
     * @return Wort-Element
     */
    public String min() {
        return listing.getFirst();
    }

    /**
     * Entfernt das Element mit dem kleinsten Schlüssel aus der Warteschlange
     */
    public void getMin() {
        listing.removeFirst();
    }

    /**
     * Ersetzt das Element mit dem kleinsten Schlüssel in der Warteschlange
     durch das Element x.
     * @param x Wort der einzulesenden Datei
     */
    public void replaceMin(String x) {
        listing.set(0, x);
    }
}
