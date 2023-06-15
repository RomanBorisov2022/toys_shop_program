
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyQueue {

    private PriorityQueue<Toy> toys;

    public ToyQueue() {
        toys = new PriorityQueue<Toy>(new ToyComparator());
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void getToys() {
        try {
            FileWriter fileWriter = new FileWriter("result.txt");
            for (int i = 0; i < 10; i++) {
                Toy toy = toys.poll();
                double random = Math.random();
                if (random <= 0.2) {
                    toy = toys.stream().filter(t -> t.getId() == 1).findFirst().get();
                } else if (random <= 0.4) {
                    toy = toys.stream().filter(t -> t.getId() == 2).findFirst().get();
                }
                fileWriter.write(toy.getName() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}