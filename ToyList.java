import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ToyList {
    private PriorityQueue<Toy> toys;

    public ToyList() {
        toys = new PriorityQueue<>((t1, t2) -> Double.compare(t2.getWeight(), t1.getWeight()));
    }

    public void addNewToy(Toy toy, int weight) {
        toy.setWeight(weight);
        toys.offer(toy);
    }

    public void modifyWeight(Toy toy, int newWeight) {
        toys.remove(toy);
        toy.setWeight(newWeight);
        toys.offer(toy);
    }

    public Toy chooseToy() {
        double sum = 0;
        for (Toy toy : toys) {
            sum += toy.getWeight();
        }
        
        double random = Math.random() * sum;
        double current = 0;
        for (Toy toy : toys) {
            current += toy.getWeight();
            if (current >= random) {
                return toy;
            }
        }
        return null;
    }

    public Toy getToy(int id) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public void removeToy(Toy toy) {
        toys.remove(toy);
    }

    public List<Toy> getToys() {
        return new ArrayList<>(toys);
    }
}