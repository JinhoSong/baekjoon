package string;

import java.io.*;
import java.util.Stack;

class baekjoon2908 {
    public void No2908() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        String[] line = br.readLine().split(" ");
        double size = 0.1;
        for (int i = 0; i < line[0].length(); i++) {
            s1.push((int) line[0].charAt(i) - '0');
            s2.push((int) line[1].charAt(i) - '0');
            // - '0' 하면 아스키코드 값을 알 필요 없이 그냥 정수로 변환되서 나온다.
            size *= 10;
        }
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < 3; i++) {

            n1 += s1.pop()*size;
            n2 += s2.pop()*size;
            size/=10;
        }
        int result = (n1 > n2) ? n1 : n2;
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}

public class No2908 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2908().No2908();
    }
}
