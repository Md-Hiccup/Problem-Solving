package prob;

import java.util.function.Function;

/**
 * Created by dastaniqbal on 21/08/2019.
 * ask2iqbal@gmail.com
 * 21/08/2019 10:52
 */
public class Wagon {
    private int[] wagons;

    public Wagon(int wagonCount, Function<Integer, Integer> fillWagon) {
        wagons = new int[wagonCount];

        for (int i = 0; i < wagonCount; i++) {
            wagons[i] = fillWagon.apply(i).intValue();
        }
    }

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        final int wagonCount = 100_000_000;
        final Wagon train = new Wagon(wagonCount, x -> x);
        for (int i = 0; i < wagonCount; i++) {
            System.out.println("Wagon: " + i + ", cargo: " + train.peekWagon(i));
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    public int peekWagon(int wagonIndex) {
        return wagons[wagonIndex];
    }
}
