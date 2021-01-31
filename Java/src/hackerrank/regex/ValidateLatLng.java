package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLatLng {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        Pattern p = Pattern.compile("^\\([+-]*(?:[0-9](?:\\.\\d+)?|[0-8][0-9](?:\\.\\d+)?|90(?:\\.0{1,})?),\\s[+-]*(?:([0-9](?:\\.\\d+)?|[1-9][0-9](?:\\.\\d+)?|1[0-7][0-9](?:\\.\\d+)?|180(?:\\.0{1,})?))\\)$");
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);
            if (m.matches()) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}