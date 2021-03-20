package programmers.level2;

import java.io.IOException;

public class transfer124 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int number = 2;
        System.out.println(solution(number));
    }
    public static String solution(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }

}
