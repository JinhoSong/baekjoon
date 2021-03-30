package programmers.level2;

import java.io.IOException;
import java.util.PriorityQueue;

public class priortySpicy {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [] scoville = {1,1};
        int k = 7;
        System.out.println((solution(scoville,k)));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int val : scoville){
            priorityQueue.add(val);
        }

        while(!(priorityQueue.peek() >=K)){
            if(priorityQueue.size() <2)
                return -1;
            int n1 = priorityQueue.poll();
            int n2 =priorityQueue.poll();
            n2 = n1+((n2)*2);
            priorityQueue.add(n2);
            answer++;
        }

        return answer;
    }
}
