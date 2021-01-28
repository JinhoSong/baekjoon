package backtracking;
import java.io.*;

class baekjoon9663 {

    public static int[] arr;
    public static int count = 0;
    public static int n;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No9663() throws NumberFormatException, IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        // 각 행에는 하나의 열에만 퀸이 있을 수 있다.
        // 1열부터 N열까지 돌면서 각 1행 N열에 퀸을 놓았을때 가능한 경우를 확인한다.

        dfs(0);
        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }

    public static void dfs(int depth) {

        if(depth == n){
            // n까지 탐색을 마친 경우
            count++;
            return ;
        }

        for(int i=0;i<n;i++){
            // n*n의 체스판이니까 n까지 한다.
            arr[depth] = i; // 퀸의 위치를 저장하고
            if(check(depth)){
                // 퀸을 둘 수 있는지 체크한다. 가능하다면 다음 탐색으로 넘어간다.
                dfs(depth+1);
            }
            //arr[depth] = 0;
        }

    }

    public static boolean check(int col) {


        for(int i=0;i<col;i++){

            // 가로에 퀸이 있는 경우
            if(arr[col] == arr[i]){
                return false;
            }
            // 대각선에 퀸이 있는 경우
            if(Math.abs(arr[col] - arr[i]) == Math.abs(col-i)){
                return false;
            }

        }

        return true;
    }


}

public class No9663 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon9663().No9663();
    }
}