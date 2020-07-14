package stack;

import java.io.*;
import java.util.Stack;

class baekjoon4949 {
    public void No4949() throws NumberFormatException, IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {// 일단 무한으로 돌리고 .

            boolean result = true;
            stack.clear();
            String str = br.readLine();
            if (str.charAt(0) == '.' && str.length() == 1)
                break;// '.' 하나면 탈출 시키고.
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (temp == '(' || temp == '[') {
                    //여는 괄호괄호만 넣는다.
                    stack.push(temp);
                } else if (temp == ')' || temp == ']') {
                    // 닫는 괄호의 경우
                    if (!stack.empty()) {
                        //비어 있지 않다면
                        //top의 괄호와 닫는 괄호의 짝을 지어본다.
                        char top = stack.pop();
                        if (top == '(' && temp == ')' || top == '[' && temp == ']') {
                            result = true; //통과하면 맞는거다.
                        } else {// 괄호 불일치로 실패
                            result = false;
                            break;
                        }
                    } else {

                        result = false;
                        break;
                        //비어 있는데 닫는 괄호면 틀린거다.
                    }
                }

            }
            if (stack.empty() && result)
                bw.write("yes" + "\n");
            else
                bw.write("no" + "\n");
        }

        bw.flush();
        bw.close();
    }
}

public class No4949 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon4949().No4949();
    }
}
