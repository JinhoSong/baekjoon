package queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon5430 {
    public void No5430() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean local = true;// true를 first로 사용한다.
        boolean result = true;
        int n = Integer.parseInt(br.readLine());
        //반복할 횟수

        for (int i = 0; i < n; i++) {
            //입력은 3가지 종류로 받는다
            // 1번은 명령을 이어 붙여둔 문자열 ex) -> RDD
            // 2번은 명령을 받을 배열의 크기 ex -> 3
            // 3번은 명령을 받을 배열 ex -> [1,3,4]

            String str = br.readLine();//명령어를 한 줄 단위로 입력받음
            int size = Integer.parseInt(br.readLine()); // 다음 명령어의 크기를 입력받고
            String[] data = br.readLine().replaceAll("[\\[\\]]", "").split(",");
            //양쪽 괄호는 없애고 ,를 기준으로 나눔.
            for (int j = 0; j < size; j++) {
                //System.out.println("data[" + j + "]의 값은" + data[j]);
                deque.add(Integer.parseInt(data[j]));
                //배열을 넣고
            }
            //마지막에 조건문을 통과하기 위해 true로 설정해둔다.
            for (int j = 0; j < str.length(); j++) {
                //한 줄로 입력받은 문자열을 하나하나 쪼개서 실행하도록 charAt으로 처리한다.
                switch (str.charAt(j)) {
                    case 'R':
                        local = !local;
                        //위치를 알리는걸 반대로 표시
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            result = false;
                            break;
                        }
                        if (local)
                            deque.removeFirst();
                        else
                            deque.removeLast();
                        break;
                    // D는 큐의 맨 앞을 제거하는 명령
                }

            }
            String finalResult;
            //System.out.println("테스트입니다"+finalResult.replace(" ",""));
            if (result) {
                if (local) {
                    finalResult = deque + "";

                } else {
                    while (!deque.isEmpty()) {
                        queue.add(deque.removeLast());
                    }
                    finalResult = queue + "";
                }
                bw.write(finalResult.replace(" ", "") + "\n");
            } else {
                bw.write("error" + "\n");
            }
            deque.clear();
            queue.clear();
            local = true;
            result = true;
        }

        bw.flush();
        bw.close();

    }
}

public class No5430 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon5430().No5430();
    }
}
