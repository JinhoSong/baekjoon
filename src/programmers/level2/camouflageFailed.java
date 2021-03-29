package programmers.level2;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class camouflageFailed {
    public static void main(String[] args) throws NumberFormatException, IOException {

        //String[][] c = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        //String [][] c ={{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] c = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}, {"test", "test"}};
        System.out.println((solution(c)));
    }

    private static int[] arr;
    private static boolean[] visited;
    private static int answer = 0;
    private static HashMap<String, Integer> resultHashMap = new LinkedHashMap<>();

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        for (String[] str : clothes) {
            if (hashMap.get(str[1]) == null) {
                // 키가 비어있으면
                hashMap.put(str[1], 1);
            } else {
                hashMap.put(str[1], hashMap.get(str[1]) + 1);
            }
        }
        int add = 0;
        int size = hashMap.size();
        arr = new int[size];
        visited = new boolean[size];
        int index = 0;
        for (int val : hashMap.values()) {
            arr[index++] = val;
            add += val;
        }

        if (hashMap.size() == 1) {
            return add;
        } else {
            dfs( 0, arr.length);

            for (int val : resultHashMap.values()) {
                answer += val;
            }
            return answer;
        }
    }

    public static void dfs(int depth, int len) {
        if (depth == len) {
            String str = "";
            int result = 1;
            int index = 0;
            for (boolean t : visited) {
                str = str.concat(t + "");
                if (t) {
                    result = arr[index] * result;
                }
                index++;
            }
            //System.out.println("str    : " + str);
            resultHashMap.putIfAbsent(str, result);
            return;
        }
        while (!(len == -1)) {
            for (int i = depth; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, len);
                    visited[i] = false;
                }
            }
            len -= 1;
        }

    }
}