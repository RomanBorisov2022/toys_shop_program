

import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {

    @Override
    public int compare(Toy toy1, Toy toy2) {
        if (toy1.getWeight() < toy2.getWeight()) {
            return -1;
        } else if (toy1.getWeight() > toy2.getWeight()) {
            return 1;
        }
        return 0;
    }

}