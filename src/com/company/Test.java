package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println((Arrays.toString(solution(info, query))));
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, Integer> scoreList = new HashMap<>();

        int index = 0;
        for (String f : info) {
            String[] str = f.split(" ");
            for (String s : str) {
                hashMap.put(s, hashMap.getOrDefault(s, "") + index + " ");
            }
            index++;
            scoreList.put(str[4],Integer.parseInt(str[4]));
        }

        index = 0;
        for (String q : query) {
            int match = 5; // 기본은 5개가 매칭되어야 정답이다
            int[] arr = new int[info.length];
            String[] sql = q.replace(" and", "").split(" ");
            String add = "";
            for (String s : sql) {
                if (s.equals("-")) {
                    // "-"의 경우 전부 통과이므로 비교안해도 된다.
                    match--;
                } else {
                    add = add.concat(hashMap.getOrDefault(s, ""));
                }
            }

            if (!(sql[4].equals("-"))) {
                for (int val : scoreList.values()) {
                    if (val > Integer.parseInt(sql[4])) {
                        add = add.concat(hashMap.getOrDefault(val + "", ""));
                    }
                }
            }
            String[] str = add.split(" ");
            for (String s : str) {
                arr[Integer.parseInt(s)]++;
            }
            for (int val : arr) {
                if (val == match) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}