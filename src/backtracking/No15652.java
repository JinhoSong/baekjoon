package backtracking;

import java.io.*;

class baekjoon15652{
    public static boolean[] visit;
    public static int[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void No15652() throws NumberFormatException, IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new int[m];  // 2
        visit = new boolean[n]; // 4

        dfs(n, m, 0);

        bw.flush();
        bw.close();
    }

    public static void dfs(int n, int m, int depth) throws IOException {
        if (depth == m) {
            // depth 와 m이 같아지면 출력에 필요한 arr이 전부 채워진거니까 출력을 한다.

            // 오름차순인지 검사하는 반복문
            for(int i=1;i<m;i++){
                if(arr[i-1] > arr[i])
                    return;
            }
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }
        // depth 와 m이 같지 않다면 탐색하러 들어간다.
        for (int i = 0; i < n; i++) {
            arr[depth] = i +1;
            dfs(n, m, depth + 1);
        }
    }
}

public class No15652 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon15652().No15652();
    }
}
