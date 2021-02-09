package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon1012 {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int line, size, count = 0;
    public static int size_x, size_y;
    public static int[] number;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No1012() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        for (int a = 0; a < n; a++) {
            String [] str = br.readLine().split(" ");
            size_x = Integer.parseInt(str[0]);
            size_y = Integer.parseInt(str[1]);
            arr = new int[size_x][size_y];
            visit = new boolean[size_x][size_y];
            size = Integer.parseInt(str[2]);
            for (int i = 0; i < size; i++) {
                str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                arr[x][y] =1;
            }
            number = new int[size_x * size_y];
            count=0;
            bfs();
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    public void bfs() {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    // System.out.println(i+ " "+j+" ");
                    visit[i][j] = true;
                    count++;
                    Queue<Integer> a = new LinkedList<>();
                    Queue<Integer> b = new LinkedList<>();
                    a.add(i);
                    b.add(j);
                    int[] dx = {-1, 1, 0, 0};
                    int[] dy = {0, 0, -1, 1};
                    while (!a.isEmpty() && !b.isEmpty()) {
                        int n1 = a.poll();
                        int n2 = b.poll();
                        number[count]++;
                        for (int k = 0; k < dx.length; k++) {
                            int nx = n1 + dx[k];
                            int ny = n2 + dy[k];
                            if (nx >= 0 && nx < size_x && ny >= 0 && ny < size_y) {
                                // 값이 정상이고
                                if (!visit[nx][ny] && arr[nx][ny] == 1) {
                                    // 방문 안했고 이동할 수 있다면
                                    visit[nx][ny] = true;
                                    a.add(nx);
                                    b.add(ny);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


public class No1012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1012().No1012();
    }
}
