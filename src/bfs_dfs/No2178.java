package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon2178 {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int line, size, count = 0;
    public static int size_x, size_y;
    public static int[] number;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No2178() throws NumberFormatException, IOException {
        String[] str = br.readLine().split(" ");
        size_x = Integer.parseInt(str[0]);
        size_y = Integer.parseInt(str[1]);
        arr = new int[size_x][size_y];
        visit = new boolean[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < size_y; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 0,0 부터 size_x, size_y까지 최단거리를 찾아야 한다.
        bfs();
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    public void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        Node n = null;
        while (!q.isEmpty()) {
            n = q.poll();
            int x = n.x;
            int y = n.y;
            int d = n.depth;
            visit[x][y] = true;
            int[] nx = {-1, 1, 0, 0};
            int[] ny = {0, 0, 1, -1};
            for (int i = 0; i < nx.length; i++) {
                int dx = nx[i] + x;
                int dy = ny[i] + y;
                if (dx < size_x && dx >= 0 && dy < size_y && dy >= 0 && arr[dx][dy] == 1 && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    q.add(new Node(dx, dy, d + 1));
                    if (visit[size_x - 1][size_y - 1]) {
                        System.out.println(d+1);
                        System.exit(0);
                    }
                }
            }

        }
    }

}

class Node {
    int x;
    int y;
    int depth;

    Node(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;

    }
}


public class No2178 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2178().No2178();
    }
}
