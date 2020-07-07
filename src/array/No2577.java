package array;

import java.io.*;

public class No2577 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 3; //3번 받고
        int p [] = new int [10];
        int count [] = new int [10];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        int result = p[0]*p[1]*p[2];
        //axbxc -> 결과에 대한 숫자 계산
        // 10으로 나눈 나머지의 1의 몫-> 1의자리
        // 100으로 나눈 나머지의 10의 몫 -> 10의 자리
        for(int i=1;i<result;i=i*10){
            count[ result %(i*10)/i]++;
        }
        for(int i=0;i<10;i++)
            bw.write(Integer.toString(count[i])+"\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
