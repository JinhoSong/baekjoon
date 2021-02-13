package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon1697 {
    public static int[] arr;
    public static boolean[] visit;
    public static int size, count = 0;
    public static int size_x, size_y;
    public static int number = 0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No1697() throws NumberFormatException, IOException {
        String[] str = br.readLine().split(" ");
        int n1 = Integer.parseInt(str[0]);
        int n2 = Integer.parseInt(str[1]);
        arr = new int[100001];
        visit = new boolean[100001];
        arr[n1] = 1; //수빈이
        arr[n2] = 2; // 동생
        if (n1 == n2)
            System.out.println(0);
        else
            bfs(n1, n2);
        bw.flush();
        bw.close();
    }

    public void bfs(int n1, int n2) {
        //이동은 앞뒤로 한칸 or 순간 이동 x*2
        Queue<Node1697> queue = new LinkedList<>();

        queue.add(new Node1697(n1, 0));
        visit[n1] = true;
        Node1697 node;
        int depth = 0;
        while (!queue.isEmpty()) {
            node = queue.poll();
            int local = node.x;
            depth = node.depth;
            int[] dx = {-1, 1, local};
            for (int value : dx) {
                int k = value + local; // 이동가능한 위치들
                if (k >= 0 && k < 100001 &&!visit[k]) {
                    if (arr[k] == 2) {
                        //동생이 있는 경우
                        System.out.println(depth + 1);
                        System.exit(0);
                    } else {
                        visit[k] = true;
                        queue.add(new Node1697(k, depth + 1));
                    }
                }
            }
        }

    }
}
class Node1697 {
    int x;
    int depth;

    public Node1697(int x, int depth) {
        this.x = x;
        this.depth = depth;
    }
}


public class No1697 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1697().No1697();
    }

}
