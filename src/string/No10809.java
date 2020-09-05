package string;
import java.io.*;
class baekjoon10809 {
    public void No10809() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word  = br.readLine();
        int []arr = new int [26];
        for(int i=0;i<26;i++){
            arr[i]=-1;
        }
        //a=97
        for(int i=0;i<word.length();i++){
            char w = word.charAt(i);
            int index = (int)w - 97;
            if(arr[index] == -1)
                arr[index]= i;

        }
        for(int i=0;i<26;i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}

public class No10809 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon10809().No10809();
    }
}
