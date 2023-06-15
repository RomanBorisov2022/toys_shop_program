import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ToyQueue toyQueue = new ToyQueue();

        toyQueue.addToy(new Toy("1", "doll", 6));
        toyQueue.addToy(new Toy("2", "robot", 2));
        toyQueue.addToy(new Toy("3", "car", 3));

        for (int i = 0; i < 10; i++) {
            if (toyQueue.givePrizeToy()) {
                System.out.printf("Prize toy %d given\n", i + 1);
            } else {
                System.out.println("No prize toy available");
            }
        }

        List<Toy> prizeToys = toyQueue.getAllPrizeToys();
        try {
            File file = new File("prize_toys.txt");
            FileWriter writer = new FileWriter(file);
            for (Toy prizeToy : prizeToys) {
                writer.write(prizeToy.getName() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}