package dynamic_programming;

import java.io.*;

class baekjoon1003 {
    public static int[][] arr;
    public static boolean[] visit;
    public static boolean[] box;
    public static int count_0,count_1;
    public static int n, answer;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void No1003() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        int []zeroCount = new int[41];
        int []oneCount = new int[41];
        zeroCount[0]=1;
        oneCount[0]=0;
        zeroCount[1]=0;
        oneCount[1]=1;

/*        for(int i=0;i<n;i++){
            int number = Integer.parseInt(br.readLine());
            count_0=0;
            count_1=0;
            fibonacci(number);
            bw.write(count_0+ " "+count_1+"\n");
        }*/

        for(int i=2;i<41;i++){
            zeroCount[i]=oneCount[i-1];
            oneCount[i]=zeroCount[i-1]+oneCount[i-1];
        }

        for(int i=0;i<n;i++){
            int number = Integer.parseInt(br.readLine());
            bw.write(zeroCount[number]+ " "+oneCount[number]+"\n");
        }

        bw.flush();
        bw.close();
    }

    public int fibonacci(int n){
        if(n==0){
            count_0++;
            return 0;
        } else if( n==1){
            count_1++;
            return 1;
        } else {
            return fibonacci(n-1)+ fibonacci(n-2);
        }
    }
}


public class No1003 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1003().No1003();
    }
}
