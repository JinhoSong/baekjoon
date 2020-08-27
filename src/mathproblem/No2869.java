package mathproblem;

import java.io.*;


class baekjoon2869 {
    public void No2869() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        int up = Integer.parseInt(str[0]);
        int down = Integer.parseInt(str[1]);
        int high = Integer.parseInt(str[2]);
        int count = 0;
        int share; //몫
        int remainder; //나머지

        high = high - down; //하루치를 빼고
        count = high / (up - down);
        remainder = high % (up - down);
        if (remainder != 0)
            count++;



        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}

public class No2869 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2869().No2869();
    }
}
