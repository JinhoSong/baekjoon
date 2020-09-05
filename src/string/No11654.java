package string;

import java.io.*;

class baekjoon11654 {
    public void No11654() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char word = br.readLine().charAt(0);
        int number = (int)word;
        bw.write(number+"");
        bw.flush();
        bw.close();

    }
}

public class No11654 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon11654().No11654();
    }
}
