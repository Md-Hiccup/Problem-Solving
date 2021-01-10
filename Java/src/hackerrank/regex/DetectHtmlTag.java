package hackerrank.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlTag {

    static HashSet<String> set = new HashSet<String>();

    static void detectHtml(String str) {
        Pattern pattern = Pattern.compile("<\\s*([\\/a-zA-Z0-9]+)\\s*>*");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            set.add(matcher.group(1).replace("/", ""));
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            detectHtml(line);
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(";");
            }
        }
    }
}
