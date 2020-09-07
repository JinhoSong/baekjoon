package string;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class baekjoon1316 {
    public void No1316() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        int index;
        int result = n;
        for(int i=0;i<n;i++){
            queue.clear();
            String [] word = br.readLine().split("");
            queue.addAll(Arrays.asList(word));
            boolean []arr = new boolean[26];
            for(int j=0;j<word.length;j++){
                String str = queue.poll();
                index = str.charAt(0)-'a';
                if(!str.equals(queue.peek())){
                    if(arr[index]){
                        //두개가 다른데 이미 true로 처리되어 있다면
                        result --;
                        break;
                    } else {
                        arr[index] = true;
                    }
                }
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}

public class No1316 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1316().No1316();
    }
}
