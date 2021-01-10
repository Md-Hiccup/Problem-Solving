package hackerrank.regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindASubWord {

    static int findASubWord(String line, String regex) {
        Pattern p = Pattern.compile("(?<=\\w)(" + regex + ")(?=\\w)");
        Matcher m = p.matcher(line);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> search = new ArrayList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            lines.add(line);
        }

        int q = Integer.parseInt(in.nextLine());
        for (int i = 0; i < q; i++) {
            String line = in.nextLine();
            search.add(line);
        }

        for (String s : search) {
            int sum = 0;
            for (String line : lines) {
                sum += findASubWord(line, s);
            }
            System.out.println(sum);
        }
    }
}
