package programmers.level2;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class skillTrees {
    public static void main(String[] args) throws NumberFormatException, IOException {

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA","C","B",""};
        //String[] skill_trees = {"C"};
        System.out.println(solution(skill, skill_trees));
    }
    // 전부 안 맞을때랑
    // 스킬트리가 비어있을 때

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (String str : skill_trees) {
            for (int i = 0; i < skill.length(); i++) {
                queue.add(str.indexOf(skill.charAt(i))); // 현재 비교할 것
            }
            int[] arr = new int[queue.size()];
            int[] arr2 = new int[queue.size()];
            int val = -2;
            boolean result = true;
            boolean start = false;
            for (int i = 0; i < arr.length; i++) {
                if (val == -1 && queue.peek() != -1 && start) {
                    //앞에꺼가 없는데 뒤에가 있는 경우
                    result = false;
                    break;
                } else {
                    if( val > -1){
                        // 값이 있다면
                        start = true;
                    }
                    val = queue.poll();
                    if( val ==-1){
                        arr[i] = 1000000;
                        arr2[i] = 1000000;
                    } else {
                        arr[i] = val;
                        arr2[i] = val;
                    }
                }
            }
            // 0 -1 -1 2
            // -1 -1 0

            Arrays.sort(arr);
            for (int i = 0; i < skill.length(); i++) {
                if (arr[i] != arr2[i] ) {
                    // 순서가 다르다면
                    result = false;
                    break;
                }
            }
            queue.clear();
            if (result)
                answer++;
        }
        return answer;
    }
}
