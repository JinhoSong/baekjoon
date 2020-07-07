package array;

import java.io.*;
import java.util.StringTokenizer;

public class No1546 {


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double p [] = new double [n];
        double max = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Double.parseDouble(st.nextToken());
            if(p[i] > max )
                max=p[i];
        }
        double result=0;
        for(int i=0;i<n;i++){
            p[i] = p[i]*100/max;
            result = result + p[i];
        }

        bw.write(Double.toString(result/n));
        bw.flush();
        br.close();
        bw.close();

    }
}
