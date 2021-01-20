package hackerrank.regex;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectDomain {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashSet set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Pattern p = Pattern.compile("(?<=(http[s]?:\\/\\/(?:(ww2.)|(www.))?))(?!www.)(?!ww2.)([a-zA-Z\\d]+\\.[a-zA-Z\\d]*\\.?[a-zA-Z\\d]+\\.?[a-zA-Z\\d]+)");
            Matcher m = p.matcher(line);
            while (m.find()) {
                set.add(m.group(4));
            }
        }

        TreeSet<String> treeSet = new TreeSet<>(set);
        int i = 0;
        for (String value : treeSet) {
            System.out.print(value);
            if (i < treeSet.size()-1)
                System.out.print(";");
            i++;
        }
    }
}
