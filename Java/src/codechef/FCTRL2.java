package codechef;

/***
 * Problem Statement
 *
 You are asked to calculate factorials of some small positive integers.

 Input
 An integer t, 1<=t<=100, denoting the number of testcases, followed by t lines, each containing a single integer n, 1<=n<=100.

 Output
 For each integer n given at input, display a line with the value of n!

 Example
 Sample input:
 4
 1
 2
 5
 3
 Sample output:
 24
 1
 2
 120
 6
 */

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by IQBAL-MEBELKART on 8/15/2016.
 */
public class FCTRL2 {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t>0) {
            int n=scanner.nextInt();
            BigInteger sum=new BigInteger("1");
            for (int i = 1;i<=n;i++) {
                sum=sum.multiply(new BigInteger(String.valueOf(i)));
            }
            System.out.println(sum);
            t--;
        }
    }
}

