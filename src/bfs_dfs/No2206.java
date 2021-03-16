package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon2206 {
    public static int[][] arr;
    public static boolean[][][] visit;
    public static int size, count = 0;
    public static int size_x, size_y;
    public static int number = 0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No2206() throws NumberFormatException, IOException {
        String[] str = br.readLine().split(" ");

        size_x = Integer.parseInt(str[0]);
        size_y = Integer.parseInt(str[1]);
        arr = new int[size_x][size_y];
        visit = new boolean[size_x][size_y][2];
        for (int i = 0; i < size_x; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < size_y; j++) {
                // [x,y]
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        if (size_x == 1 && size_y == 1) {
            System.out.println(1);
            System.exit(0);
        }
        bfs();
        bw.flush();
        bw.close();
    }

    public void bfs() {
        visit[0][0][0] = true;
        visit[0][0][1] = true;
        Queue<Node2206> queue = new LinkedList<>();
        queue.add(new Node2206(0, 0, 1, false));
        int depth = 0;
        while (!queue.isEmpty()) {
            // 벽을 안 부수고 이동하는 경우
            Node2206 node = queue.poll();

            int x = node.x;
            int y = node.y;
            depth = node.depth;
            boolean block = node.block;
            int[] nx = {0, 0, 1, -1};
            int[] ny = {1, -1, 0, 0};
            for (int i = 0; i < nx.length; i++) {
                int dx = x + nx[i];
                int dy = y + ny[i];
                if (dx == size_x - 1 && dy == size_y - 1) {
                    // 도착한 경우
                    System.out.println(depth + 1);
                    System.exit(0);
                }
                if (dx < size_x && dx >= 0 && dy < size_y && dy >= 0) {
                    // 사이즈가 정상적으로 내부에 존재하고
                    if (block) {
                        // block = true
                        // 이미 벽을 한번 부신 경우
                        if (arr[dx][dy] == 0 && !visit[dx][dy][0]) {
                            // 이동 가능 할때
                            visit[dx][dy][0] = true;
                            queue.add(new Node2206(dx, dy, depth + 1, true));
                        }
                    } else {
                        // 벽을 아직 안 부신 경우
                        // blcok = false
                        if (arr[dx][dy] == 0 && !visit[dx][dy][1]) {
                            // 이동가능하면
                            visit[dx][dy][1] = true;
                            queue.add(new Node2206(dx, dy, depth + 1, false));

                        } else if (arr[dx][dy] == 1 && !visit[dx][dy][1]) {
                            // 한번 부수는 경우
                            visit[dx][dy][1] = true;
                            queue.add(new Node2206(dx, dy, depth + 1, true));
                        }
                    }
                }

            }

        }
        System.out.println(-1);
    }

}

class Node2206 {
    int x;
    int y;
    boolean block;
    int depth;

    public Node2206(int x, int y, int depth, boolean block) {
        this.x = x;
        this.y = y;
        this.block = block;
        this.depth = depth;
    }
}


public class No2206 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2206().No2206();
    }

}
