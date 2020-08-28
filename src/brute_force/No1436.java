package brute_force;

import java.io.*;

class baekjoon1436 {
    public void No1436() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        int count = 0;
        int number = 665;
        while (!(n == count)) {
            number++;
            if (number % 1000 == 666 || number/10 %1000==666 || number/100 %1000==666 || number/1000 %1000==666 || number/10000 %1000==666) {
                count++;
            }

        }
        bw.write(number + "");

        bw.flush();
        bw.close();

    }
}

public class No1436 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1436().No1436();
    }
}
