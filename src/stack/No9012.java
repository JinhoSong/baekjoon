package stack;

import java.io.*;
import java.util.Stack;

class baekjoon9012 {
    public void No9012() throws NumberFormatException, IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stack.clear();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char temp = str.charAt(j);
                stack.push(temp);
            }
            int result = 0;

            while (!stack.empty()) {
                if (stack.pop().equals(')'))
                    result++;
                else
                    result--;
                //System.out.println(result);
                if(result < 0)
                    break;
            }
            if (result == 0)
                bw.write("YES" + "\n");
            else
                bw.write("NO"+"\n");


        }
        bw.flush();
        bw.close();
    }
}

public class No9012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon9012().No9012();
    }
}
