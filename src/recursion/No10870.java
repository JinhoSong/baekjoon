package recursion;

import java.io.*;

class baekjoon10870 {
    public void No10870() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());


        bw.write(Fibonacci(number) + "");
        bw.flush();
        bw.close();
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return Fibonacci(n - 2) + Fibonacci(n - 1);


    }

}

public class No10870 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon10870().No10870();
    }
}
