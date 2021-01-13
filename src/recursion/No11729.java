package recursion;

import java.io.*;

class baekjoon11729 {
    public int result = 0;
    public void No11729() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        bw.write((int)(Math.pow(2,number)-1)+"\n");
        //System.out.println과 혼용해서 쓰면 안된다.
        hanoi(1,2,3,number,bw);

        bw.flush();
        bw.close();
    }

    public void hanoi(int from, int m, int to, int number, BufferedWriter bw) throws IOException {

        if(number ==0)
            return ;
        result++;
        hanoi(from,to, m, number-1,bw); // 원판 number-1이  form -> m 으로 이동
        bw.write(from+" "+to+"\n");
        //System.out.printf("%d %d\n",number,to);//원판num이 from -> to 이동 14:
        hanoi(m,from,to,number-1,bw); // 원판num-1이 m -> to로 이동
    }

}

public class No11729 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon11729().No11729();
    }
}
