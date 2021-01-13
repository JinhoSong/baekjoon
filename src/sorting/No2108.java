package sorting;

import java.io.*;
import java.util.Arrays;

class baekjoon2108 {
    public void No2108() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        int[] arr = new int[count];
        int avg = 0;
        int[] mode = new int[8001]; // 최빈값을 계산하기 위한 배열
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            avg += arr[i]; // 평균을 구하기 위해 각 값을 더한다.
            mode[arr[i] + 4000]++; // 동시에 최빈값도 계산.
        }
        int min = 0;
        for (int value : mode) {
            if (min < value) {
                min = value;
            }
        }
        int[] two_min = new int[2];
        int j = 0;
        for (int i = 0; i < mode.length; i++) {
            if (two_min[0] != 0 && two_min[1] != 0)
                break;
            if (min == mode[i]) {
                two_min[j] = i;
                j++;
            }
        }
        if (two_min[1] == 0)
            two_min[1] = two_min[0];


        Arrays.sort(arr);

        bw.write(avg / count + "\n");
        bw.write(arr[count / 2] + "\n");
        bw.write(two_min[1] - 4000+"\n");
        bw.write(arr[count - 1] - arr[0] + "\n");

        bw.flush();
        bw.close();
    }

}

public class No2108 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2108().No2108();
    }
}

