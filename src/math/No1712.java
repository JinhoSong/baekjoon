package math;

import java.io.*;

class baekjoon1712 {
    public void No1712() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int fixedCost = Integer.parseInt(str[0]);
        int varCost = Integer.parseInt(str[1]);
        int price = Integer.parseInt(str[2]);
        int count = 0;

        if (fixedCost > 0 && varCost >= price) {
            bw.write("-1\n");

        } else {
            while ((price - varCost) * count <= fixedCost) {
                count++;
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }

}

public class No1712 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1712().No1712();
    }
}
