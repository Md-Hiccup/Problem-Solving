package geeksforgeeks;

public class ReverseAString {

    public static void main(String[] args) {
        System.out.println(reverseWord("Geeks"));
        System.out.println(reverseWithoutNewString("Geeks"));
    }

    public static String reverseWord(String str) {
        char[] ch = new char[str.length()];
        int index = 0;
        for (int i = str.length(); i > 0; i--) {
            ch[index++] = str.charAt(i - 1);
        }
        return new String(ch);
    }

    public static String reverseWithoutNewString(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(start);
            chars[start] = str.charAt(end);
            chars[end] = tmp;
            start++;
            end--;
        }
        return new String(chars);
    }
}
