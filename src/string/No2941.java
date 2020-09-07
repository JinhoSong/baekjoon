package string;

import java.io.*;

class baekjoon2941 {
    public void No2941() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String []tmp = {"c=", "c-","dz=","d-","lj","nj","s=","z="};
        for(int i=0;i<tmp.length;i++){
            line = line.replace(tmp[i],"*");
        }
        System.out.println(line.length());
        bw.flush();
        bw.close();
    }
}

public class No2941 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2941().No2941();
    }
}

