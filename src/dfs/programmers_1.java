package dfs;
import java.io.*;

class DFS {
    public void dfs_1() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int []numbers = {1, 1, 1, 1, 1};
        int target=3;
        int n=0; // 인덱스 시작
        int answer = dfs(numbers,n,target,0);
        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
    public int dfs(int [] numbers,int n, int target,int sum){
        if(numbers.length <= n){
            // 최말단 도착
            if(sum == target)
                return 1;
            else
                return 0;
        } else {
            // n 이 index이면 +1 해서 시작하도록 하면된다.
            int r = numbers[n];
            n++;
            return dfs(numbers,n,target,sum + r) + dfs(numbers,n,target,sum- r);
        }
    }

}

public class programmers_1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new DFS().dfs_1();
    }
}
