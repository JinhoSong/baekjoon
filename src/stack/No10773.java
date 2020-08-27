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
        if(stack.empty() == true)
            bw.write(0+"\n");
        else {
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            bw.write(result+"\n");
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
