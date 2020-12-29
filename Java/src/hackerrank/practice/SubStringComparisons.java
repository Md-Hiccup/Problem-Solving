package hackerrank.practice;

import java.util.Arrays;
import java.util.Scanner;

public class SubStringComparisons {

    static String lexicoOrder(String str1, String str2, boolean isSmall) {
        String result = str1;
        System.out.println(str1 + ":" + str2);

        for (int i = 0; i < str1.length(); i++) {
            boolean b = str1.charAt(i) < str2.charAt(i);
            boolean b1 = str1.charAt(i) > str2.charAt(i);
            if (isSmall) {
                if (b1) {
                    result = str2;
                    break;
                } else if (b) {
                    result = str1;
                    break;
                }
            } else {
                if (b) {
                    result = str2;
                    break;
                } else if (b1) {
                    result = str1;
                    break;
                }
            }
        }


        System.out.println(result + ":" + isSmall);
        return result;
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        String[] arr = new String[s.length() - k + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.substring(i, i + k);
        }

        smallest = largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            String value = arr[i];
            if (largest.charAt(0) < value.charAt(0)) {
                largest = value;
            } else if (largest.charAt(0) == value.charAt(0)) {
                largest = lexicoOrder(largest, value, false);
            }
            if (smallest.charAt(0) > value.charAt(0)) {
                smallest = value;
            } else if (smallest.charAt(0) == value.charAt(0)) {
                smallest = lexicoOrder(smallest, value, true);
            }

        }

        return smallest + "\n" + largest;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
