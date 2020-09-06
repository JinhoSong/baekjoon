package string;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

class baekjoon1157 {
    public void No1157() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine().toUpperCase();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = new int[26];
        //a =97
        //A= 65
        for (int i = 0; i < word.length(); i++) {
            int number = (int) word.charAt(i);

            arr[number - 'A']++;
            //전부 소문자로 바꾸고 배열의 index로 알파벳이 몇번 호출되었는지 체크한다.
        }
        //System.out.println(Arrays.toString(arr));
        // arr에 알파벳의 빈도수는 다 저장되어 있는데. 배열말고 다른곳에 저장하는게 더 효율적인건가?
        // 우선순위 큐에 넣으려고 했는데 얘는 겹치는 값은 그냥 한개로 처리하는듯 함.
        for (int i = 0; i < 26; i++) {
            queue.add(arr[i]);
        }
        int max =0;
        int local = 0;

        if(queue.poll().equals(queue.peek())) {
            bw.write("?");
        }
        else {
            for (int i = 0; i < 26; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    local = i;
                    //가장 많이 언급된 알파벳은 찾았다.
                }
            }
            local = local + 'A';
            bw.write((char) local);
        }
        bw.flush();
        bw.close();
    }
}

public class No1157 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1157().No1157();
    }
}
