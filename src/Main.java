import java.io.*;
import java.util.StringTokenizer;


// 자바 기본 입출력 세팅
public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int p [] = new int [n];
        int max = -100000;
        int index = 0;
        //StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            if(p[i] > max ) {
                index = i;
                max = p[i];
            }
        }
        bw.write(Integer.toString(max));
        bw.write(Integer.toString(index));
        bw.flush();
        br.close();
        bw.close();

    }
}
