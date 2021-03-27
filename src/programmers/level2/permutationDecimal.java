package programmers.level2;

import java.io.IOException;

public class permutationDecimal {
    public static void main(String[] args) throws NumberFormatException, IOException {

        String numbers = "01234";
        System.out.println((solution(numbers)));
    }


    private static int count = 0;
    private static boolean[] decimal;
    private static int[] arr;
    private static String[] str;
    private static boolean[] visited;
    public static int solution(String numbers) {
        // 아리스토의 체를 만들어 두고
        // 7칸이 가능하니까 0이 7개
        decimal = new boolean[10000001];

        decimal[0]=true;
        decimal[1]=true;
        for(int i=2;i<10000000;i++){
            if(!decimal[i]){
                for(int j=i+i;j<10000000;j+=i){
                    decimal[j]=true;
                }
            }
        }
        // 소수를 모두 세팅해두고

        dfs("",0,arr.length);

        // permutation("",numbers);

        return count;
    }
    public static void permutation(String prefix, String str){
        int n =str.length();
        if (!prefix.equals("")) {
            int num = Integer.parseInt(prefix);
            if(!decimal[num]){
                count++;
                decimal[num]=true;
            }
        }
        // str.substring(0,i)+str.substring(i+1,n) -> prefix를 제외한 부분을 넘긴다.
        for(int i=0;i<n;i++){
            //System.out.println("prefix : "+prefix+" str : "+str+" 호출방식은 "+prefix+str.charAt(i)+" "+str.substring(0,i)+str.substring(i+1,n));
            permutation(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
        }
    }

    public static void dfs(String prefix, int depth,int len) {
        if (depth == len) {
            int num = Integer.parseInt(prefix);
            if(!decimal[num]){
                count++;
                decimal[num] = true;
            }
            return;
        }
        while(!(len ==-1)){
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    //방문한 적이 없다면
                    prefix = prefix + str[i];
                    visited[i] = true;
                    dfs(prefix, depth + 1,len);
                    prefix = prefix.substring(0, prefix.length() - 1);
                    visited[i] = false;
                }
            }
            len-=1;
        }
    }

}


