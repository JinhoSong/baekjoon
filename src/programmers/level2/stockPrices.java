package programmers.level2;

import java.io.IOException;
import java.util.Arrays;

public class stockPrices {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int[] prices = {1,2,3,4,3,2,1};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {

        int[] result = new int [prices.length];
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i] <= prices[j]){
                    result[i]++;
                }
                else if( prices[i] > prices[j]){
                    result[i]++;
                    break;
                }
            }
        }

        return result;

    }
}