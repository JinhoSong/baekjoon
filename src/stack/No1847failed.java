package stack;
import java.io.*;
import java.util.Stack;

class baekjoon1847failed {
    public void No1847failed() throws NumberFormatException, IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int top = 0;
        int input;
        int arr[] = new int[n];// 지금까지 넣은걸 저장하는 배열
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            // 이미한번 체크한 숫자는 빼고 push 해야된다.
            for (int j = top; j <= input; j++) { // 1 2 3 4 push
                boolean flag = true;
                for (int k = 0; k < arr.length - 1; k++) {
                    if (arr[k] >= j) {
                        flag = false;
                    }
                }
                if (flag) {
                    stack.push(j);
                    arr[i] = j; // 푸쉬한 숫자는 기억한다.
                    top = stack.peek();
                    bw.write("+\n");
                }
            }
            //pop을 합시다 이제
            //System.out.println("top 값은 = "+top);
            if(input < top){
                for (int j = input; j < top; j++) {
                    bw.write("-\n");
                    top = stack.pop();
                }
            }else{
                bw.write("-\n");
                top = stack.pop();
            }

        }
        bw.flush();
        bw.close();
    }
}
public class No1847failed {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1847failed().No1847failed();
    }
}