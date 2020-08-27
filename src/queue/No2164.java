package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon2164 {
    public void No2164() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        //큐는 LinkedList를 매개체로 사용한다.
        int n = Integer.parseInt(br.readLine());
        int data=1; // 1 일 경우 생각해야 됨
        for(int i=1;i<=n;i++){
            queue.add(i);

        }
        //큐에 다 넣고
        while( queue.size() != 1){
            queue.remove(); //맨 앞에 하나를 제거 하고
            data = queue.element(); // 그 다음껄 저장하고
            queue.remove(); // 앞에 하나 더 제거하고
            queue.add(data);
//            System.out.println("tests");
//            System.out.println(data);

        }
        bw.write(data+"\n");
        bw.flush();
        bw.close();
    }
}

public class No2164 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2164().No2164();
    }
}
