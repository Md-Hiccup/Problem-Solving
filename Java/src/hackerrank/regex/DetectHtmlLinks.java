package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlLinks {
    public static void main(String[] str) {
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("<a href=\"(.+?)\".*?>\\s?([^<]*)<\\/",Pattern.MULTILINE);

        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);
            while (m.find()) {
                System.out.println(m.group(1) + "," + m.group(2));
            }
        }
    }
}
