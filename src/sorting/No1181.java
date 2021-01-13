package sorting;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class baekjoon1181 {
    public void No1181() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        String [][]arr = new String[count][2];

        for(int i=0;i<count;i++){
            String[] word = br.readLine().split(" ");
            String age = word[0];
            String name = word[1];
            arr[i][0] = age;// 나이
            arr[i][1] = name;	// 이름
        }
        /*
         Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                if(Integer.parseInt(s1[0]) == Integer.parseInt(s2[0])){
                    return s1[1].compareTo(s2[1]);
                } else {
                    return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]); //오름차순
                }
            }
            // 동일한 나이는 입력순서로 정렬됨
        });
         */

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                // 정렬기준을 선택
                //return Integer.parseInt(s2[0]) - Integer.parseInt(s1[0]); // 내림차순
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]); //오름차순
            }
            // 동일한 나이는 입력순서로 정렬됨
        });

        for(int i = 0; i < count; i++) {
            bw.write(arr[i][0] + " " + arr[i][1]+"\n");
        }

        bw.flush();
        bw.close();
    }

}

public class No1181 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1181().No1181();
    }
}
