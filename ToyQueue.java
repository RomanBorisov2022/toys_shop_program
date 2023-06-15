import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyQueue {
    private PriorityQueue<Toy> queue;
    private Random random;
    private List<Toy> prizeToys;

    public ToyQueue() {
        queue = new PriorityQueue<>((t1, t2) -> (int) (t1.getWeight() - t2.getWeight()));
        random = new Random();
        prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        queue.add(toy);
    }

    public void updateToyWeight(String id, double weight) {
        Toy toy = queue.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
        if (toy != null) {
            toy.setWeight(weight);
        }
    }

    private Toy chooseToy() {
        double rand = random.nextDouble() * 100;
        if (rand < 20) {
            return queue.stream().filter(t -> t.getWeight() <= 1).findFirst().orElse(null);
        } else if (rand < 40) {
            return queue.stream().filter(t -> t.getWeight() > 1 && t.getWeight() <= 2).findFirst().orElse(null);
        } else {
            return queue.stream().filter(t -> t.getWeight() > 2 && t.getWeight() <= 6).findFirst().orElse(null);
        }
    }

    public boolean givePrizeToy() {
        if (!queue.isEmpty()) {
            Toy prizeToy = chooseToy();
            if (prizeToy != null) {
                queue.remove(prizeToy);
                prizeToys.add(prizeToy);
                return true;
            }
        }
        return false;
    }

    public List<Toy> getAllPrizeToys() {
        return prizeToys;
    }
}