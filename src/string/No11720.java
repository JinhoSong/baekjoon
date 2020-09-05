package string;

import java.io.*;

class baekjoon11720 {
    public void No11720() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String numberList = br.readLine();
        int result=0;

        for(int i=0;i<n;i++){
            result= Integer.parseInt(numberList.charAt(i)+"")+result;

        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}

public class No11720 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon11720().No11720();
    }
}
