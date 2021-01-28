package backtracking;

import java.io.*;

class baekjoon2580 {
    public static int[][] arr;
    public static boolean[] visit;
    public static boolean[] box;
    public static int count;
    public static int n;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No2580() throws NumberFormatException, IOException {
        n = 9;
        count = 0;
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] == 0)
                    count++; //빈칸의 갯수 체크
            }
        }
        dfs(0, 0);
        bw.flush();
        bw.close();
    }

    public static void dfs(int row, int col) throws IOException {
        if (col == 9){
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int val : arr[i]) {
                    bw.write(val+" ");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            // 시스템 종료
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 0; i <=9; i++) {
                // 넘기는 값은 행, 열 , 값
                // 값은 9까지 비교해야되므로 i<=9
                if (check(row, col, i)) {
                    // 가로 상자에 같은 숫자가 없는 경우
                    arr[row][col] = i; // 숫자를 넣고
                    dfs(row, col + 1);

                }
            }
            arr[row][col] = 0;
            return;
        }
        // 숫자가 꽉차 있는 경우 일로 넘어온다.
        dfs(row, col + 1);
    }

    public static boolean check(int row, int col, int value) {

        for (int i = 0; i <n; i++) {
            //행을 기준으로 열을 검사해서
            if (arr[row][i] == value) {
                return false;
            }

            if (arr[i][col] == value) {
                return false;
            }
        }

        int set_row = (row / 3) * 3;    // value가 속한 3x3의 행의 첫 위치
        int set_col = (col / 3) * 3;    // value가 속한 3x3의 열의 첫 위치
        // 상자 범위 구하기 기억하기...
        // 사이즈가 4로 늘어나면 /4 *4
        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class No2580 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2580().No2580();
    }
}