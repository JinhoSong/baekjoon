package programmers.level2;

import java.io.IOException;
import java.util.HashMap;

public class camouflage {
    public static void main(String[] args) throws NumberFormatException, IOException {

        //String[][] c = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        //String [][] c ={{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] c = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}, {"test", "test"}};
        System.out.println((solution(c)));
    }

    public static int solution(String[][] clothes) {

        HashMap<String, Integer> hm = new HashMap();
        int answer = 1;

        for (String[] clothe : clothes) { // 아무것도 안입은 상태도 개수로 친다.
            hm.put(clothe[1], hm.getOrDefault(clothe[1], 1) + 1);
        }
        // 2 1 1

        for (int i : hm.values()) {

            answer *= i;
        }
        //옷을 하나도 입지 않은 상태를 빼준다.
        return answer-1;
    }
}
