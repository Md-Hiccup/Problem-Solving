package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindHackerRankConversation {

    static int findHackerRank(String line) {
        String text = "hackerrank";
        Matcher m = Pattern.compile(text + "$").matcher(line);
        if (m.find() && m.group(0).equals(text)) {
            return 2;
        }

        m = Pattern.compile("^" + text).matcher(line);
        if (m.find() && m.group(0).equals(text)) {
            return 1;
        }

        m = Pattern.compile("^" + text + "$").matcher(line);
        if (m.find() && m.group(0).equals(text)) {
            return 0;
        }

        return -1;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            System.out.println(findHackerRank(line));
        }
    }
}
