package hackerrank.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAWord {

    static int findAWord(List<String> sentences, String word) {
        int count = 0;
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        for (String sentence : sentences) {
            Matcher m = p.matcher(sentence);
            while (m.find()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String str[]) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        List sentences = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            sentences.add(in.nextLine());
        }

        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            System.out.println(findAWord(sentences, in.nextLine()));
        }
    }
}
