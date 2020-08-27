package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon1021 {
    public void No1021() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> output = new LinkedList<>();

        String[] str = (br.readLine().split(" "));
        int size = Integer.parseInt(str[0]); //첫 입력은 사이즈
        int n = Integer.parseInt(str[1]); // 두번째 입력은 찾아야 되는 숫자의 갯수
        //1~ n까지
        for (int i = 1; i <= size; i++) {
            queue.offer(i);
        }
        String[] out = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            output.offer(Integer.parseInt(out[i]));
        }
        //output과 순서대로 넣은 큐 두가지를 만들어 낸 뒤
        int tmp;
        int count;
        int result = 0;
        while (!output.isEmpty()) {
            //output 큐가 사라질때까지
            count = 0;//시작

            while (output.peek() != queue.peek()) {
                //output순서와 input큐의 순서가 같은게 나올때까지
                tmp = queue.remove();
                queue.add(tmp);
                //일치하지 않으면 맨 앞에꺼를 뒤로 넘긴다.
                count++;
                //돌아간 횟수를 기억한다.
            }
            //여기까지 왔다는건 2개의 큐 맨 앞이 동일하다는 것이다.
            if (queue.size()/2 >= count) {
                //사이즈를 반으로 나눈 값이 count보다 작거나 같으면 앞쪽으로 회전한 결과가 작은것이다.
                result += count;
            } else {
                //반대로 크다면 뒤쪽으로 회전한 결과가 작은것이다.
                result += queue.size() - count;
            }
            output.remove();
            queue.remove();
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }
}

public class No1021 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1021().No1021();
    }
}
