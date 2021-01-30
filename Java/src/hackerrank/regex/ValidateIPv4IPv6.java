package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateIPv4IPv6 {
    static void IPAddressValidation(String line) {
        if (Pattern.compile("(\\d|\\d{2}|1\\d\\d|2[0-5][0-6])\\.(\\d|\\d{2}|1\\d\\d|2[0-5][0-6])\\.(\\d|\\d{2}|1\\d\\d|2[0-5][0-6])\\.(\\d|\\d{2}|1\\d\\d|2[0-5][0-6])\\b").matcher(line).matches()) {
            System.out.println("IPv4");
        } else if (Pattern.compile("([0-9a-f]?[0-9a-f]?[0-9a-f]?[0-9a-f]:*){8}+").matcher(line).matches()) {
            System.out.println("IPv6");
        }else{
            System.out.println("Neither");
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            IPAddressValidation(line);
        }
    }
}
