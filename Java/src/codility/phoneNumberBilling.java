package codility;

import java.util.*;

/**
 * Created by IQBAL-MEBELKART on 8/25/2016.
 */
public class phoneNumberBilling {

    public static int solution(String S) {
        String lines[] = S.split("\n");
        HashMap<String, String> aList = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            //Seperate duration and phone number
            String line[] = lines[i].split(",");
            if (aList.containsKey(line[1])) {
                //incremnet number count and update charges
                String value = aList.get(line[1]);
                String valSplit[] = value.split(",");
                aList.put(line[1], (calculateCent(line[0]) + Integer.parseInt(valSplit[0])) + "," + (Integer.parseInt(valSplit[1]) + 1));
            } else {
                //aList.put(line[1], 1 + "");
                aList.put(line[1], calculateCent(line[0]) + "," + 1);
            }
        }

        String number = "";
        int longestCalls = 1;
        for (Map.Entry<String, String> set : aList.entrySet()) {
            String value[] = set.getValue().split(",");
            int count = Integer.parseInt(value[1]);
            if (count >= longestCalls) {
                longestCalls = count;
                number = set.getKey();
            }
        }
        //remove from list longest call number
        //aList.put(aList.get(number), "0,0");
        aList.remove(number);

        int totalBill = 0;
        //Find Totlal Bill
        for (Map.Entry<String, String> setBill : aList.entrySet()) {
            String value[] = setBill.getValue().split(",");
            int billAmount = Integer.parseInt(value[0]);
            totalBill += billAmount;
        }

        return totalBill;
    }

    public static int calculateCent(String duration) {
        String timeSplit[] = duration.split(":");
        int recHour = Integer.parseInt(timeSplit[0]);
        int recMin = Integer.parseInt(timeSplit[1]);
        int recSecond = Integer.parseInt(timeSplit[2]);
        if (recMin >= 5) {
            if (recSecond == 0) {
                return recMin * 150;
            } else {
                return (recMin + 1) * 150; //extra 1 for seconds
            }
        } else {
            int totSec = (recMin * 60) + recSecond; //total seconds
            return totSec * 3; //3 cents/second
        }
    }

    public static void main(String... str) {
        //solution("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:01,701-080-080\n00:05:00,400-234-090\n00:01:07,400-234-090");
        solution("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090");
    }


}
