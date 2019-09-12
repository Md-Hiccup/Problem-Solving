package codility;

import java.util.Stack;

/**
 * Created by IQBAL-MEBELKART on 8/25/2016.
 */
public class CountParantthesis {

    public static int solution(String s) {
        char[] st = s.toCharArray();
        int totalPair = 0, closingPair = 0;
        Stack<Character> pushOpenOnly = new Stack<>();
        for (int i = 0; i < st.length; i++) {
            if (st[i] == '(') {
                pushOpenOnly.push(st[i]);
                continue;
            }
            if (st[i] == ')' && !pushOpenOnly.empty()) {
                String pair = pushOpenOnly.pop() + "" + st[i];
                if (pair.equals("()"))
                    totalPair++;
            }else{
                closingPair++;
            }
        }
        System.out.println("Pair:"+totalPair+" ClossingPair:"+closingPair);
        return (totalPair + closingPair);
    }

    public static void main(String... str) {
        System.out.println(solution("((()()))))))("));
    }
}
