package programmers.level2;

import java.io.IOException;
import java.util.Arrays;

public class TriangularSnail {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int numbers = 5;
        System.out.println((solution(numbers)));
    }

    public static int[] solution(int n) {
        int [][]arr = new int[n][n];
        // n 은 2차원 배열에서 행과 열의 길이다
        // 세로 가로 대각선으로 3회 반복된다.
        int number = 1;
        int i=0,j=0;
        int max=(n*(n+1))/2;
        int[] answer = new int[max];
        while(max > number){
            // 세로로 내려온다.
            while(i+1 < n &&arr[i+1][j] ==0){
                arr[i++][j]=number++;
            }
            // 가로로 넘어가고
            while(j+1<n  && arr[i][j+1]==0){
                arr[i][j++]=number++;
            }
            // 대각으로 올라간다.
            while (i-1 >0 && j-1>0 && arr[i-1][j-1]==0){
                arr[i--][j--]=number++;
            }
        }
        arr[i][j]=number;
        int index = 0;
        for(int []a : arr){

            for(int val : a){
                System.out.print(val+" ");
                if(val!=0){
                    answer[index]=val;
                    index++;
                }
            }
            System.out.println("");
        }

        System.out.println(Arrays.toString(answer));
        return answer;

    }


}




