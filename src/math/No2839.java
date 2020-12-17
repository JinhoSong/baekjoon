import java.io.*;

class baekjoon2839 {
    public void No2839() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int kg = Integer.parseInt(str[0]);

        int count5 = 0;
        int count3 = 0;
        int result;
        while (true) {
            if (kg % 5 == 0) {
                count5 = kg / 5;
                // 5로 나누어 떨어질때
                result = count5 + count3;
                break;
            } else {
                kg = kg - 3;
                count3++;
            }
            if(kg < 0){
                result = -1;
                break;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

}

public class No2839 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2839().No2839();
    }
}
