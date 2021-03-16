package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon7576 {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int  size, count = 0;
    public static int size_x, size_y;
    public static int number=0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No7576() throws NumberFormatException, IOException {
        String[] str = br.readLine().split(" ");
        size_x = Integer.parseInt(str[1]);
        size_y = Integer.parseInt(str[0]);
        arr = new int[size_x][size_y];
        visit = new boolean[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < size_y; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 0,0 부터 size_x, size_y까지 최단거리를 찾아야 한다.
        bfs();
        bw.flush();
        bw.close();
    }

    public void bfs() {
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<size_x;i++){
            for(int j=0;j<size_y;j++){
                if(arr[i][j] == 1){
                    // 익은 토마토라면
                    count++;
                    number++;
                    q.add(new Node(i,j,0));
                } else if(arr[i][j] == 0){
                    number++;
                }
            }
        }

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
                if (dx < size_x && dx >= 0 && dy < size_y && dy >= 0 && arr[dx][dy] == 0 && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    q.add(new Node(dx, dy, d + 1));
                    count++;
                }
            }
        }
        if(count == number){
            System.out.println(n.depth);
        } else {
            System.out.println(-1);
        }
    }

}

//class Node {
//    int x;
//    int y;
//    int depth;
//
//    Node(int x, int y, int depth) {
//        this.x = x;
//        this.y = y;
//        this.depth = depth;
//
//    }
//}



public class No7576 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon7576().No7576();
    }
}