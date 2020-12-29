package hackerrank.practice;

import java.io.*;
import java.util.*;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        if(s.length()==0){
            System.out.println(0);
        }else {
            String[] str = s.trim().replaceAll("([ !,?._'@])+", " ").split(" ");
            System.out.println(str.length);
            for (String value : str) {
                System.out.println(value);
            }
        }
        scan.close();
    }
}

