package brute_force;

import java.io.*;

class baekjoon2231 {
    public void No2231() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        //int로 안받고 일단 문자열로 받음
        int n = Integer.parseInt(str);
        //n의 최대 값 1,000,000
        int result=0;
        int tmp=0;
        for(int i=1;i<n;i++){
            int k=1;
            tmp=i%10;
            //1의 자리는 미리 더해두고
            for(int j=0;j<str.length();j++){
                k*=10;
                tmp+=i%(k*10)/k;
                //10배씩 커지면서 나눠서 자릿수를 구한다.
            }

            if(tmp+i == n) {
                result = i;
                break;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();

    }
}

public class No2231 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2231().No2231();
    }
}
