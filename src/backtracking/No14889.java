package backtracking;

import java.io.*;

class baekjoon14889 {
    public static int[][] arr;
    public static int[] team;
    public static boolean[] visit;
    public static int count = 0;
    public static int n, total, min;
    public static int score;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No14889() throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        team = new int[n / 2];
        total = 0;

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                total += arr[i][j];
            }
        }
        visit = new boolean[n];
        min = 1000000000;
        dfs(0,0);
        bw.write(min + "\n");
        bw.flush();
        bw.close();

    }

    public static void dfs(int index, int depth) {

        if (depth == n / 2) {

            // 절반으로 팀 구성이 완료되면
            getMin();
            return;
        }
        for (int i = index; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                team[depth] = i;
                dfs(i+1,depth + 1);
                team[depth] = -1;
                visit[i] = false;
            }
        }
    }

    public static void getMin() {
        score = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i] && visit[j]) {
                    score += arr[i][j];
                }
                if (!visit[i] && !visit[j]) {
                    count += arr[i][j];
                }
            }
        }
        if (Math.abs(score - count) < min) {
            min = Math.abs(score - count);
        }

    }
}

public class No14889 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon14889().No14889();
    }
}
