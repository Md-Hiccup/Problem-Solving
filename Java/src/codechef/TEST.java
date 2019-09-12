package codechef;

/**
 * Problem Statement
 *
 * Your program is to use the brute-force approach in order to find the Answer to Life,
 * the Universe, and Everything. More precisely... rewrite small numbers from input to output.
 * Stop processing input after reading in the number 42. All numbers at input are integers of one or two digits.
 Example
 Input:
 1
 2
 88
 42
 99
 Output:
 1
 2
 88
 *
 */

import java.util.Scanner;

public class TEST {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num != 42)
            System.out.println(num);

        while (num != 42) {
            num = scanner.nextInt();
            if (num != 42)
                System.out.println(num);
        }
    }
}
