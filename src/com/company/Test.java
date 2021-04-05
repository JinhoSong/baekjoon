package com.company;

import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80"
        };

        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        System.out.println((Arrays.toString(solution(info, query))));

    }

    public static int[] solution(String[] info, String[] query) {
        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        String[] language = {"java", "python", "cpp", "-"};
        String[] occupation = {"frontend", "backend", "-"};
        String[] career = {"junior", "senior", "-"};
        String[] food = {"chicken", "pizza", "-"};

        for (String s1 : language) {
            for (String s2 : occupation) {
                for (String s3 : career) {
                    for (String s4 : food) {
                        hashMap.put(String.join("",s1,s2,s3,s4),new LinkedList<>());
                    }
                }
            }
        }


        for (String str : info) {
            String[] s = str.split(" ");
            int score = Integer.parseInt((s[4]));
            String x = "-";
            String[] s1 = {s[0], x};
            String[] s2 = {s[1], x};
            String[] s3 = {s[2], x};
            String[] s4 = {s[3], x}; // 경우의 수 전부
            for (String str1 : s1) {
                for (String str2 : s2) {
                    for (String str3 : s3) {
                        for (String str4 : s4) {
                            String key = String.join("",str1,str2,str3,str4);
                            List<Integer> list = hashMap.get(key);
                            list.add(score);
                            hashMap.put(key, list);
                        }
                    }
                }
            }
        }
        for(String str : hashMap.keySet()){
            Collections.sort(hashMap.get(str));
        }

        int[] answer = new int[query.length];

        int index = 0;
        for (String q : query) {
            String[] qr = q.replaceAll(" and ", " ").split(" ");
            String key = String.join("", qr[0], qr[1], qr[2], qr[3]);
            int score = Integer.parseInt(qr[4]);
            int ret = Collections.binarySearch(hashMap.get(key),score);

            if( ret < 0){
                ret = -(ret+1);
            } else {
                for(int j=ret-1; j >=0;j--){
                    if(hashMap.get(key).get(j) == score){
                        ret = j;
                    } else {
                        break;
                    }
                }
            }
            answer[index++] = hashMap.get(key).size()-ret;
        }
        return answer;
    }
}