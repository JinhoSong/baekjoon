package array;

import java.io.*;
import java.util.StringTokenizer;

public class No10818 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int p [] = new int [n];
        int min = 1000000;
        int max = -1000000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if(p[i] > max )
                max= p[i];
            if( p[i] < min)
                min = p[i];
        }
        bw.write(Integer.toString(min)+" "+Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();

    }
}
