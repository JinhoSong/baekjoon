package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon2606 {
    public static int[][] arr;
    public static boolean[] visit;
    public static int line, size,count=0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No2606() throws NumberFormatException, IOException {
        size = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        arr = new int[size+1][size+1];
        for(int i=0;i<line;i++){
            String []str = br.readLine().split(" ");
            arr[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            arr[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
        }
        visit = new boolean[size+1];
        bfs(1);
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }

    public void bfs(int n){
        visit[n]= true;
        // 방문을 체크하고
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            n = q.poll();
            for (int j = 1; j < size + 1; j++) {
                if (!visit[j] && arr[n][j] == 1) {
                    visit[j] = true;
                    q.add(j);
                    count++;
                }
            }
        }

    }

}


public class No2606 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2606().No2606();
    }
}
