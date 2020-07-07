package array;

import java.io.*;

public class No8958 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String [] p = new String [n];
        for (int i = 0; i < n; i++) {
            p[i] = br.readLine();
            int length= p[i].length();
            int result = 0;
            int score =1;
            for(int j=0;j<length;j++){
                if(p[i].substring(length-j-1,length-j).equals("O")){
                    result+=score;
                    score++;
                } else {
                    score=1;
                    //틀렸으면
                }
            }
            bw.write(Integer.toString(result)+"\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
