package programmers.level2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class numbersSort {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [] numbers = {1,0,91};
        System.out.println((solution(numbers)));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String [] str = new String[numbers.length];

        int index = 0;
        for(int val : numbers){
            str[index++] = val+"";
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });

        if(str[0].equals("0"))
            return "0";

        for(String s : str){
            answer+=s;
        }

        return answer;
    }
}