package bfs_dfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon2667 {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int line, size, count = 0;
    public static int[] number;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No2667() throws NumberFormatException, IOException {
        size = Integer.parseInt(br.readLine());
        arr = new int[size][size];
        visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        number = new int[size * size];
        bfs();
        bw.write(count + "\n");
        Arrays.sort(number);
        // 정렬시키기 까먹지말자!
        for (int i = size*size-count; i < size*size; i++)
            bw.write(number[i] + "\n");
        bw.flush();
        bw.close();
    }

    public void bfs() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    //
                    //System.out.println(i+ " "+j+" ");
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
                            if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
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


public class No2667 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2667().No2667();
    }
}
