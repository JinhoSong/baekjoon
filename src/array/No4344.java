package array;

import java.io.*;
import java.util.StringTokenizer;

public class No4344 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());

            double[] score = new double[p];
            double add = 0.0;
            double avg = 0.0;
            for(int j=0;j<p;j++){
                score[j] = Double.parseDouble(st.nextToken());
                add+=score[j];
            }
            avg=add/p;
            double count = 0;
            for(int j=0;j<p;j++){
                if(score[j] > avg)
                    count++;
            }
            double result = count*100/p;

            bw.write(String.format( "%.3f",(result))+"%\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
