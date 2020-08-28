package brute_force;

import com.company.baekjoon;

import java.io.*;

class baekjoon1018 {
    public void No1018() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        int col = Integer.parseInt(str[0]); //세로 길이
        int row = Integer.parseInt(str[1]); //가로 길이
        char[][] chess = new char[col][row];
        for (int i = 0; i < col; i++) {
            String color = br.readLine();
            for (int j = 0; j < row; j++) {
                chess[i][j] = color.charAt(j);
                //System.out.print(color.charAt(j));
                //체스판 색칠
            }
        }
        //칠해야되는 사각형 갯수 구하기
        int result = 65;
        int count = 0;
        char c;
        for (int i = 0; i < col - 7; i++) {
            for (int j = 0; j < row - 7; j++) {
                c = chess[i][j] == 'B' ? 'B' : 'W';
                count = 0;

                for (int k = i; k < 8 + i; k++) {
                    for (int a = j; a < 8 + j; a++) {
                        if (chess[k][a] != c) {
                            count++;
                            //System.out.println("i=" + i + " j=" + j + " " + k + " " + a + " " + chess[k][a] + "가 " + c + "랑 다르니까 바꾼다.");
                        }
                        c = c == 'B' ? 'W' : 'B';
                    }
                    c = c == 'B' ? 'W' : 'B';
                }
                if(count >32)
                    count=64-count;
                if (count < result)
                    result = count;

            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();

    }
}

public class No1018 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1018().No1018();
    }
}
