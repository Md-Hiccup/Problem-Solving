package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienUsername {
    static void alienUsername(String line) {
        Pattern p = Pattern.compile("^[_.]\\d+[a-zA-Z]*_?$");
        Matcher m = p.matcher(line);
        if (m.matches()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            alienUsername(line);
        }
    }
}
