package stack;


import java.io.*;
import java.util.Stack;
class baekjoon10773 {
    public void No10773() throws NumberFormatException, IOException {
        Stack <Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int str = Integer.parseInt(br.readLine());
            switch (str){
                case 0 : stack.pop();break;
                default: stack.push(str);break;
            }
        }
        int result = 0;
        if(stack.pop() == '(')// 검사할 필요도 없이 실패
            bw.write(0+"\n");
        else { // '('로 시작 안했으면 완벽하게 괄호가 다 닫히면 양쪽 갯수가 똑같아진다.
            while (!stack.isEmpty()) {
                if( stack.pop() =='(')
                    result++;
                else
                    result--;
            }
            if( result == 0)
                bw.write("NO"+"\n");
            else
                bw.write("YES"+"\n");
        }
        bw.flush();
        bw.close();
    }
}
public class No10773 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon10773().No10773();
    }
}

