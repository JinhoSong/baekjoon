package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int size, count = 0;
    public static int size_x, size_y;
    public static int number = 0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No() throws NumberFormatException, IOException {
        int m = 6, n = 4;
        arr = new int[m][n];
        //[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]
        arr[0]= new int[]{1, 1, 1, 0};
        arr[1]= new int[]{1, 2, 2, 0};
        arr[2]= new int[]{1, 0, 0, 1};
        arr[3]= new int[]{0, 0, 0, 1};
        arr[4]= new int[]{0, 0, 0, 3};
        arr[5]= new int[]{0, 0, 0, 3};
        visit = new boolean[m][n];
        bfs(m,n);
        bw.flush();
        bw.close();
    }

    public void bfs(int m, int n) {
        int count;
        int max = 0;
        int number = 0;
        visit[0][0] = true;
        for (int i = 0; i < m; i++) {
            count=0;
            for (int j = 0; j < n; j++) {
                if(!visit[i][j] && arr[i][j] !=0){
                    int color = arr[i][j];
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(0, 0, color));
                    Node node;
                    while (!queue.isEmpty()) {
                        number++;
                        int[] nx = {-1, 1, 0, 0};
                        int[] ny = {0, 0, -1, 1};
                        node = queue.poll();
                        for (int k = 0; k < nx.length; k++) {
                            int dx = nx[k] + node.x;
                            int dy = ny[k] + node.y;
                            if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visit[dx][dy] && node.color == arr[dx][dy]) {
                                // 범위 안에 있고 색깔이 같다고 방문한적 없다면
                                visit[dx][dy] = true;
                                queue.add(new Node(dx, dy, arr[dx][dy]));
                                count++;
                            }
                        }

                    }
                }

            }
            if(count > max ){
                max=count;
            }
        }
    System.out.println(max);
    System.out.println(number);
    }


}

class Node {
    int x;
    int y;
    int color;

    public Node(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}


public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon().No();
    }

}