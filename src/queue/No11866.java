package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon11866 {
    public void No11866() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        //큐는 LinkedList를 매개체로 사용한다.
        String [] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int pick = Integer.parseInt(str[1]);
        int tmp;
        bw.write("<");
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        // ","를 위해서 일단 처음껀 그냥 한번 수행함.
        // 비어있으면 어차피 한번 수행하고 아래서 걸러짐
        for(int i=1;i<pick;i++){
            tmp = queue.remove();
            queue.add(tmp);
        }
        bw.write(queue.remove()+"");

        while(!queue.isEmpty()){
            bw.write(", ");
            for(int i=1;i<pick;i++){
                tmp = queue.remove();
                queue.add(tmp);
            }
            bw.write(queue.remove()+"");

        }

        bw.write(">");
        bw.flush();
        bw.close();
    }
}

public class No11866 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon11866().No11866();
    }
}
