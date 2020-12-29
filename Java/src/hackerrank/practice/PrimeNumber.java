package hackerrank.practice;

import java.util.Arrays;

public class PrimeNumber {
    static void prime(int L, int R) {
        Boolean[] isPrime = new Boolean[(R - L + 1)];
        Arrays.fill(isPrime, true);

        int lim = (int) Math.sqrt(R);

        for (int i = 2; i <= lim; ++i) {
            int maxValue = Math.max(i * i, (L + i - 1) / i * i);
            for (int j = maxValue; j <= R; j += i) {
                isPrime[j - L] = false;
            }
        }

        if (L == 1)
            isPrime[0] = false;

        int count = 0;
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
                System.out.println(i);
            }
        }

        System.out.println("Size: " + count);

    }

    public static void main(String[] args) {
        prime(0, 100);
    }
}
