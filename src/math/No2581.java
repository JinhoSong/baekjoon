package math;
import java.io.*;

class baekjoon2581 {
    public void No2581() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 에라토스테네스의 체

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        // 정수 두개 사이의 소수를 모두 구한다.

        int answer = 0;
        int[] number = new int[end + 1];
        for (int i = 0; i <= end; i++) {
            number[i] = i;
            //각 인덱스 값으로 초기화
        }
        number[1] = 0; // 0과1은 소수에 포함 안됨
        for (int i = 2; i <= end; i++) {
            if (number[i] != 0) { // 처음 발견된 숫자 즉 소수일 경우
                for (int j = 2; j <= (end / i); j++) {
                    number[i * j] = 0;
                }
                answer++;
            }

        }
        int index = start;
        int result = -1;
        int sum = 0;
        while (index != end+1) {
            if (number[index] != 0) {
                if(result == -1){
                    result = number[index];
                }
                sum += number[index];
            }
            index++;
        }
        if (result != -1) {
            bw.write(sum + "\n");
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }

}

public class No2581 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2581().No2581();
    }
}

