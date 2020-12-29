package hackerrank.practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    final static String regex=".*?<([\\w\\W\\s][^<>]*)>(.[\\w\\W][^<>]*)(<\\/\\1>)";

    static void matchPattern(String line){
        Pattern pattern = Pattern.compile(regex,Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(line);
        boolean isFound = matcher.find();
        if(!isFound){
            System.out.println("None");
        }
        while(isFound){
            if(matcher.groupCount()>=3){
                String group2=matcher.group(2);
                if(pattern.matcher(group2).find()){
                    matchPattern(group2);
                }else{
                    System.out.println(group2);
                }
            }

            isFound = matcher.find();
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            matchPattern(line);
            testCases--;
        }
    }
}
