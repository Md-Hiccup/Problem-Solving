package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindHi {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        Pattern p = Pattern.compile("^[Hh][Ii]\\s[^Dd]");
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);
            if (m.find()) {
                System.out.println(line);
            }
        }
    }
}
