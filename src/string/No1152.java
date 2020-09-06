package string;

import java.io.*;

class baekjoon1152 {
    public void No1152() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        if (line.length == 0) {
            bw.write("0");
        } else {
            int result = line.length;
            if (line[0].equals(""))
                result--;
            if (line[line.length - 1].equals(""))
                result--;
            bw.write(result + "");
        }

        bw.flush();
        bw.close();
    }
}

public class No1152 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1152().No1152();
    }
}
