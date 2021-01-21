package hackerrank.regex;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectEmail {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        HashSet set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Pattern p = Pattern.compile("[a-zA-Z0-9-.%+!_]*@[a-zA-Z0-9-.%+!_]+\\.[a-z]*\\.*[a-z]*\\.*[a-z]+");
            Matcher m = p.matcher(line);
            while (m.find()) {
                set.add(m.group(0));
            }
        }

        TreeSet<String> tset = new TreeSet<String>(set);
        int i = 0;
        for (String str : tset) {
            System.out.print(str);
            if (i < tset.size() - 1) {
                System.out.print(";");
            }
            i++;
        }
    }
}
