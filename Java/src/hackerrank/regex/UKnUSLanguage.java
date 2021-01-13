package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UKnUSLanguage {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        //ArrayList<String> lines = new ArrayList<>();
        StringBuilder lines = new StringBuilder();
        for (int i = 0; i < n; i++) {
            lines.append(" ").append(in.nextLine()).append(" ");
        }

        int c = Integer.parseInt(in.nextLine());
        for (int i = 0; i < c; i++) {
            int count = 0;
            String word = in.nextLine();
            String regex = "(?<=[ ])(" + word.charAt(0) + "[" + word.substring(1, word.length() - 1) + "]+" + word.charAt(word.length() - 1) + ")(?=[ ])";
            //System.out.println(regex);
            Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher m = p.matcher(lines);
            while (m.find()) {
                count++;
            }
            System.out.println(count);
        }
    }
}
