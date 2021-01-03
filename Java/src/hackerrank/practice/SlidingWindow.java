package hackerrank.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class SlidingWindow {


    /**
     * arr = [4 3 1 2 5  3 4 7 1 9]
     * ind = [0 1 2 3 4 5  6 7 8 9]
     * dek = [4]
     * k = 4
     * <p>
     * 10 3
     * 2 3 1 5 7 1 2 5 4 3
     *
     * @param arr
     * @param k
     */
    static void slidingWindow2(int[] arr, int k) {
        Deque deque = new ArrayDeque<Integer>();
        int n = arr.length;
        int ans[] = new int[n - k + 1];

        deque.addLast(0);
        for (int i = 1; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[(int) deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        System.out.println(arr[(int) deque.peekFirst()]);

        for (int i = k; i < n; i++) {

            while (!deque.isEmpty() && arr[i] >= arr[(int) deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if ((int) deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            System.out.println(arr[(int) deque.peekFirst()]);
        }
    }

    /**
     * Find unique number in k window size
     * 6 3
     * 5 3 5 2 3 2
     * 0 1 2 3 4 5
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<Integer>();
        HashSet set = new HashSet<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            set.add(num);

            if (deque.size() == m) {
                if (set.size() > max) {
                    max = set.size();
                }

                int first = (int) deque.remove();
                if (!deque.contains(first)) set.remove(first);

            }
        }


        System.out.println(max);
    }
}
