package array;

import java.io.*;

public class No3052 {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 10;
        int p [] = new int [n];
        int count [] = new int [42];
        int result =0;
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<10;i++){
            if(count[ p[i] %42]++ == 0){
                result++;
            }
        }
        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        bw.close();

    }
}
