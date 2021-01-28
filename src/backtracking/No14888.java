package backtracking;
import java.io.*;

class baekjoon14888 {
    public static int[] arr;
    public static int[] operator;
    public static int count = 0;
    public static int n;
    public static int max,min;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No14888() throws NumberFormatException, IOException {

        // 첫 줄에는 숫자의 갯수
        // " " 숫자가 오고
        // 덧셈 뺄셈 곱셉 나눗셈의 갯수가 들어온다.

        n = Integer.parseInt(br.readLine());
        String []str = br.readLine().split(" ");
        arr = new int[n];
        for(int i=0;i<n;i++){

            arr[i] = Integer.parseInt(str[i]);
        }
        str = br.readLine().split(" ");
        operator = new int[4];
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(str[i]);
            // 연산자 몇개 씩 있는지 체크한다.
        }
        max =-1000000000;
        min =1000000000;

        dfs(arr[0],1);

        bw.write(max+"\n");
        bw.write(min+"\n");
        bw.flush();
        bw.close();

    }

    public static void dfs(int number ,int depth) {
        if(depth == n){
            max = Math.max(max, number);
            min = Math.min(min, number);
            return ;
        }
        for(int i=0;i<4;i++){
            // 4개의 연산자를 검사한다.
            if(operator[i] !=0){
                // 연산이 있다면
                operator[i]--;
                // 재귀호출시 배열을 비워두는걸 체크하기 위해 일단 값을 뺀다.
                // i=0일때 덧셈 i=1일때 뺼셈
                switch (i){
                    case 0: dfs(number+arr[depth],depth+1);break;
                    case 1: dfs(number-arr[depth],depth+1);break;
                    case 2: dfs(number*arr[depth],depth+1);break;
                    case 3: dfs(number/arr[depth],depth+1);break;
                }
                operator[i]++; // 원상복구 시킨다.
            }
        }

    }

    public static boolean check(int col) {

        return true;
    }
}

public class No14888 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon14888().No14888();
    }
}
