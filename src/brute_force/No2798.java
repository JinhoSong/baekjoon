package brute_force;

import java.io.*;

class baekjoon2798 {
    public void No2798() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String []str = (br.readLine().split(" "));
        int size = Integer.parseInt(str[0]);
        int number= Integer.parseInt(str[1]);
        int result=0;
        int tmp;
        str = br.readLine().split(" ");
        int []card = new int[size];
        for(int i=0;i<size;i++){
            card[i]=Integer.parseInt(str[i]);
        }
        for(int i=0;i<size-2;i++){
            for(int j=i+1;j<size-1;j++){
                for(int k=j+1;k<size;k++){
                    tmp=card[i]+card[j]+card[k];
                    if(tmp > result && tmp<=number){
                        result = tmp;
                    }
                }
            }

        }
        bw.write(result+"");
        bw.flush();
        bw.close();

    }
}
/*5 10
1 2 3 4 10
 */
public class No2798 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon2798().No2798();
    }
}
