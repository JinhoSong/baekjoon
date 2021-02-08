package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon1260 {
    public static int[][] arr;
    public static boolean[] visit;
    public static int n, size;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No1260() throws NumberFormatException, IOException {
        String[] str = br.readLine().split(" ");

        size = Integer.parseInt(str[0]); // 정점의 갯수
        n = Integer.parseInt(str[1]); // 간선의 갯수
        int start = Integer.parseInt(str[2]); // 시작 지점
        arr = new int[size + 1][size + 1];
        visit = new boolean[size + 1];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            arr[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            arr[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
        }
        // dfs, bfs
        dfs(start);
        bw.write("\n");
        visit = new boolean[size + 1];
        bfs(start);
        bw.flush();
        bw.close();
    }

    public void dfs(int n) throws IOException {
        bw.write(n + " ");
        if (visit[n]) {
            //방문했다면
            return;
            // 그냥 아무것도 안하고 리턴
        }
        visit[n] = true; // 안했으면 방문을 체크
        for (int i = 0; i < size + 1; i++) {
            if (arr[i][n] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public void bfs(int n) throws IOException {
        if (visit[n]) {
            // 방문했다면
            return;
        }
        visit[n] = true;
        bw.write(n + " ");
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            for (int j = 1; j < size + 1; j++) {
                if (!visit[j] && arr[n][j] == 1) {
                    visit[j] = true;
                    bw.write(j + " ");
                    q.add(j);
                }
            }
        }

    }

}


public class No1260 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1260().No1260();
    }
}
