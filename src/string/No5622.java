package string;

import java.io.*;

class baekjoon5622 {
    public void No5622() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        int result = 0;
        for(int i=0;i<line.length();i++){
            int a = line.charAt(i) -'A';
            if( a > 24)
                a-=2;
            else if( a > 17)
                a--;
            result = result + a/3 +3;
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}

public class No5622 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon5622().No5622();
    }
}

//규칙에 따라 문자에 대응하는 수를 출력하는 문제