package queue;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class baekjoon1966 {
    public void No1966() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queueIndex = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int number;

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            number = Integer.parseInt(str[0]); //반복해서 넣을 큐의 사이즈
            int result = Integer.parseInt(str[1]); // 중요한 인덱스 자리
            str = br.readLine().split(" "); // 우선순위 한 줄을 읽고

            for (int j = 0; j < number; j++) {
                int data = Integer.parseInt(str[j]);
                queue.add(data); // 하나는 그냥 큐에
                priorityQueue.add(data); //우선순위 큐에 넣고
                queueIndex.add(j); // index도 넣고
            }
            //3개의 큐를 돌린다.
            int count = 1;
            while (true) {
                while (priorityQueue.peek() != queue.peek()) {
                    //우선순위 큐와 일반 큐의 맨앞이 같아질때까지 반복
                    int tmp = queue.remove();
                    queue.add(tmp);
                    tmp = queueIndex.remove();
                    queueIndex.add(tmp);
                    //System.out.println(queueIndex+"여기다");
                }
                if(queueIndex.peek() == result)
                    break;
                else
                    count++;
                priorityQueue.remove();
                queue.remove();
                queueIndex.remove();
            }
            bw.write(count + "\n");
            priorityQueue.clear();
            queueIndex.clear();
            queue.clear();
        }

        bw.flush();
        bw.close();
    }

}

public class No1966 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1966().No1966();
    }
}
