package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartIDEDetectLanguage {
    public static void main(String[] args) {
        StringBuilder strbul = new StringBuilder();
        Scanner in = new Scanner("    import java.io.*;\n" +
                "    public class SquareNum {\n" +
                "       public static void main(String args[]) throws IOException\n" +
                "       {\n" +
                "          System.out.println(\"This is a small Java Program!\");\n" +
                "       }\n" +
                "    }");//System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            strbul.append(line.trim()).append("\n");
        }

        Pattern p = Pattern.compile("^import java");
        Matcher m = p.matcher(strbul.toString());
        if (m.find()) {
            System.out.println("Java");
            System.exit(0);
        }
        p = Pattern.compile("^#include");
        m = p.matcher(strbul.toString());
        if (m.find()) {
            System.out.println("C");
            System.exit(0);
        }

        p = Pattern.compile("print\\s*\\(?");
        m = p.matcher(strbul.toString());
        if (m.find()) {
            System.out.println("Python");
        }

        in.close();
    }
}
