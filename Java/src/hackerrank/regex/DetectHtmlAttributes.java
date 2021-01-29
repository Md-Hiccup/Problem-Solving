package hackerrank.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlAttributes {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        ArrayList<String> lines = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            lines.add(line);
        }

        for (String line : lines) {
            Pattern tagP = Pattern.compile("<(\\w+)(\\s*[^>]*)>");
            Matcher tagM = tagP.matcher(line);
            while (tagM.find()) {
                /*  Get Tag */
                String tag = tagM.group(1);
                Pattern lineP = Pattern.compile("(?<=\\s)(\\w+)(?==)");
                Matcher lineM = lineP.matcher(tagM.group(2));

                /*  check tag exist  */
                Set set = new HashSet<String>();
                if (hashMap.get(tag) != null) {
                    String attributes = hashMap.get(tag);
                    String arr[] = attributes.split(",");
                    for (String str : arr) {
                        set.add(str);
                    }
                }

                while (lineM.find()) {
                    set.add(lineM.group(0));
                }

                /*  sort  */
                TreeSet<String> treeSet = new TreeSet<>(set);
                /*  add ,  */
                StringBuilder attributes = new StringBuilder();
                int j = 0;
                for (String value : treeSet) {
                    attributes.append(value);
                    if (j < treeSet.size() - 1) {
                        attributes.append(",");
                    }
                    j++;
                }
                hashMap.put(tag, attributes.toString());
            }
        }

        Map<String, String> map = new TreeMap<>(hashMap);
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
