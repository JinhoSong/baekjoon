package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon7569 {
    public static int[][][] arr;
    public static boolean[][][] visit;
    public static int size, count = 0;
    public static int size_x, size_y;
    public static int number = 0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No7569() throws NumberFormatException, IOException {
        String[] str = br.readLine().split(" ");

        int z = Integer.parseInt(str[2]); // z
        int y = Integer.parseInt(str[1]); // y
        int x = Integer.parseInt(str[0]); // x
        arr = new int[z][y][x];
        visit = new boolean[z][y][x];
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                str = br.readLine().split(" ");
                for (int k = 0; k < x; k++) {
                    arr[i][j][k] = Integer.parseInt(str[k]);
                    if (arr[i][j][k] != -1) {
                        // 0 or 1인 경우
                        number++;
                    }
                }
            }
        }

        bfs(z,y,x);
        bw.flush();
        bw.close();
    }

    public void bfs(int z, int y, int x) {
        int depth = 0;
        Queue<Node7569> queue = new LinkedList<>();
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (arr[i][j][k] == 1) {
                        // 익은 토마토면
                        queue.add(new Node7569(i, j, k, 0));
                        visit[i][j][k] = true;
                        count++;
                    }
                }
            }
        }
        // 큐에 다 넣었다

        // n1 z
        // n2 y
        // n3 x

        while (!queue.isEmpty()) {
            // 큐가 존재하면
            Node7569 node = queue.poll();
            int nodeX = node.x;
            int nodeY = node.y;
            int nodeZ = node.z;
            depth = node.depth ; // 한턴 진행된걸 표시하기 위해

            int[] nx = {0, 0, 0, 0, 1, -1};
            int[] ny = {0, 0, 1, -1, 0, 0};
            int[] nz = {1, -1, 0, 0, 0, 0};
            for (int i = 0; i < nx.length; i++) {
                int dx = nodeX + nx[i];
                int dy = nodeY + ny[i];
                int dz = nodeZ + nz[i];
                if (dx < x && dx >= 0 && dy < y && dy >= 0 && dz < z && dz >= 0 && arr[dz][dy][dx] ==0 && !visit[dz][dy][dx]) {
                    visit[dz][dy][dx] = true;
                    queue.add(new Node7569(dz, dy, dx, depth + 1));
                    count++;
                }
            }
        }

        if (count == number) {
            System.out.println(depth);
        } else
            System.out.println(-1);
    }

}

class Node7569 {
    int x;
    int y;
    int z;
    int depth;

    public Node7569(int z, int y, int x, int depth) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.depth = depth;
    }
}

public class No7569 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon7569().No7569();
    }

}
