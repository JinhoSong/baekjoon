package com.company;

import java.io.*;
import java.util.Stack;

class baekjoon {
    public void No1849() throws NumberFormatException, IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter no = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int top = 0;
        int input;
        boolean writeFlag = true;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            // 이미한번 체크한 숫자는 빼고 push 해야된다.
            while (top + 1 <= input) {
                stack.push(top + 1);
                top = stack.peek();
                sb.append("+\n");
                // bw.write("+\n");
                //제일 높았던 숫자보다 +큰 수를 push한다 input이랑 같아질때까지
            }
            if (!stack.empty()) {//안비었으면
                if (input < stack.peek()) {//input이 더 작은거지 그러니까 pop을 하는 조건이면
                    for (int j = input; j < stack.peek(); j++) {
                        //bw.write("-\n");
                        sb.append("-\n");
                        stack.pop();
                    }
                }  //다 push하고나서 input은 pop을 해야 되니까
                //bw.write("-\n");
                sb.append("-\n");
                stack.pop();

            } else {
                writeFlag = false;
                no.write("NO");
                break;
            }
        }
        if (writeFlag) {
            System.out.print(sb.toString());
//            bw.flush();
//            bw.close();
        } else {
            no.flush();
            no.close();
        }
    }
}

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon().No1849();
    }
}