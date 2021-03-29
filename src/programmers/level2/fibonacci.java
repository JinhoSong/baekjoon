package programmers.level2;

import java.io.IOException;

public class fibonacci {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int n = 100000;
        System.out.println((solution(n)));
    }
    private static String str;

    public static int solution(int n) {
        int answer = 0;
        if(n==1)
            return 1;
        int n1,n2;
        n1=0;
        n2=1;
        for(int i=2;i<=n;i++){
            answer= (n1%1234567)+(n2%1234567);
            n1=n2%1234567;
            n2=answer%1234567;
        }

        return answer;
    }
}




