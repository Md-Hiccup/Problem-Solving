package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utopian Identification Number
 */
public class UthopianIndetificationNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-z]{0,3}\\d{2,8}[A-Z]{3,}");
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            Matcher matcher = pattern.matcher(str);
            if (matcher.matches()) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
            }
        }
    }
}
