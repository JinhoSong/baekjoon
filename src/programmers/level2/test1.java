package programmers.level2;

import java.io.IOException;
import java.util.Arrays;

public class test1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [] lottos = { 44, 1, 0, 0, 31, 25};
        int [] win_nums = { 31, 10, 45, 1, 6, 19};
        //result { 3,5}
        System.out.println((Arrays.toString(solution(lottos, win_nums))));

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        //이때, 당첨 가능한 최고 순위와 최저 순위
        int count = 0;
        int countZero=0;
        for(int val : lottos){
            if( val == 0 )
                countZero++;
            for(int val2 : win_nums){
                if(val == val2) {
                    count++;
                }
            }
        }
        answer[0] = 7 - (count+countZero); // 0과 맞춘 숫자의 합
        answer[1] = 7 - count; // 맞춘 숫자만 정확한 경우

        // 1 or 0 인 경우
        if(answer[0] == 7 || answer[0] == 6)
            answer[0]=6;
        if(answer[1] == 7 || answer[1] == 6)
            answer[1]=6;
        return answer;
    }

}