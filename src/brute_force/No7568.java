package brute_force;

import java.io.*;

class baekjoon7568 {
    public void No7568() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [][]size = new int [n][2];
        for(int i=0;i<n;i++){
            String []str= br.readLine().split(" ");
            size[i][0]= Integer.parseInt(str[0]);// 몸무게
            size[i][1]= Integer.parseInt(str[1]);// 키
        }
        // 데이터 삽입 완료 후
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=0;j<n;j++){
                if(size[i][0] < size[j][0] && size[i][1] <  size[j][1]){
                    //기준 i보다 키랑 몸무게가 둘다 크면
                    count++;
                }
            }
            bw.write(count+" ");
        }

        bw.flush();
        bw.close();

    }
}

public class No7568 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon7568().No7568();
    }
}
