import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrizeToyList {
    private Queue<PrizeToy> prizeToys;

    public PrizeToyList() {
        prizeToys = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.getId(), t2.getId()));
    }

    public void addPrizeToy(PrizeToy prizeToy) {
        prizeToys.offer(prizeToy);
    }

    public PrizeToy getPrizeToy() {
        return prizeToys.poll();
    }

    public List<PrizeToy> getPrizeToys() {
        return new ArrayList<>(prizeToys);
    }
}