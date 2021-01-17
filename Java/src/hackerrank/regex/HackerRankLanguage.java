package hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankLanguage {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        Pattern p = Pattern.compile("(?<=\\s)(?:(C)|(CPP)|(JAVA)|(PYTHON)|(PERL)|(PHP)|(RUBY)|(CSHARP)|(HASKELL)|(CLOJURE)|(BASH)|(SCALA)|(ERLANG)|(CLISP)|(LUA)|(BRAINFUCK)|(JAVASCRIPT)|(GO)|(D)|(OCAML)|(R)|(PASCAL)|(SBCL)|(DART)|(GROOVY)|(OBJECTIVEC))$");
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Matcher m = p.matcher(line);
            if (m.find()) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
            }
        }
    }
}

//|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC