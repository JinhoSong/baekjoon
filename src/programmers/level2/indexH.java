package programmers.level2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class indexH {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [] citations = {6,5,4,1,0};
        System.out.println((solution(citations)));
    }

    public static int solution(int[] citations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(citations);
        int max = citations[citations.length-1];
        for(int i=0;i<=max;i++){
            int count = 0;
            for (int citation : citations) {
                if (citation >= i)
                    count++;
            }
            if(count>=i){
                System.out.println(i+" "+count);
                priorityQueue.add(i);
            }
        }
        int answer = priorityQueue.poll();

        return answer;
    }
}