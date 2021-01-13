package backtracking;

import java.io.*;

class baekjoon15650 {
    public static boolean [] visit;
    public static int[] arr;
    public void No15650() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String []input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // ex : 4 2 의 경우
        // 각 숫자마다 방문을 체크해야되니까 boolean은 4
        // 출력할때는 2개 쌍으로 묶어서 출력하니까 배열은 2

        arr =  new int[m];  // 2
        visit = new boolean[n]; // 4

        dfs(n,m,0);

        bw.flush();
        bw.close();
    }

    public static void dfs(int n, int m, int depth){
        if(depth == m){
            // depth 와 m이 같아지면 출력에 필요한 arr이 전부 채워진거니까 출력을 한다.

            // 오름차순인지 검사하는 반복문
            for(int i=1;i<m;i++){
                if(arr[i-1] > arr[i])
                    return;
            }

            for(int val : arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        // depth 와 m이 같지 않다면 탐색하러 들어간다.
        for(int i=0;i< n;i++){
            if(!visit[i]){
                //방문하지 않았다면
                visit[i]= true; // 방문체크를하고
                arr[depth] = i + 1;
                dfs(n,m,depth +1);
                // depth+1를 호출하는 재귀를 형성하여 m과 같아지면
                // 더 이상 재귀를 호출하지 않도록 한다.
                visit[i]=false;
            }
        }
    }
}

public class No15650 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon15650().No15650();
    }
}

