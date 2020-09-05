package string;

import java.io.*;

class baekjoon2675 {
    public void No2675() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String []line;
        for(int i=0;i<n;i++){
            line= br.readLine().split(" ");
            for(int j=0;j<line[1].length();j++){
                for(int k=0;k<Integer.parseInt(line[0]);k++){
                    bw.write(line[1].charAt(j));
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}

public class No2675 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2675().No2675();
    }
}
