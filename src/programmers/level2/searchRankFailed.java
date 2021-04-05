package programmers.level2;

import java.io.IOException;
import java.util.*;

public class searchRankFailed {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
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
        int[] answer = new int[query.length];
        HashMap<String, LinkedList<Integer>> hashMap = new HashMap<>();
        String[] language = {"java", "python", "cpp"};
        String[] occupation = {"frontend", "backend"};
        String[] career = {"junior", "senior"};
        String[] food = {"chicken", "pizza"};
        String[][] stringList = {language, occupation, career, food};


        for (String str : info) {
            String[] information = str.split(" ");
            String c = "";
            for (int i = 0; i < information.length - 1; i++) {
                c = c.concat(information[i]);
            }
            int val = Integer.parseInt(information[information.length - 1]);
            LinkedList<Integer> linkedList;
            linkedList = hashMap.getOrDefault(c, new LinkedList<>());
            linkedList.add(val);
            hashMap.put(c, linkedList);
        }

        int index = 0;
        String[] result = new String[24];

        for (String s1 : language)
            for (String s2 : occupation)
                for (String s3 : career)
                    for (String s4 : food) {
                        result[index++] = s1 + s2 + s3 + s4;
                    }
        index=0;
        for (String str : query) {
            boolean[] check = new boolean[4];
            String[] q = str.replace(" and ", " ").split(" ");
            for (int i = 0; i < 4; i++) {
                if (q[i].equals("-")) {
                    check[i] = true;
                }
            }
            String [] lastResult = result.clone();

            for(int i=0;i<4;i++){
                if(!check[i]){
                    // 정해진 문자의 경우 q[i]가 정해진거다
                    for(int j=0;j<lastResult.length;j++){
                        if(!lastResult[j].contains(q[i])){
                            lastResult[j]="";
                        }
                    }
                }
            }
            for (String sss : lastResult) {
                LinkedList<Integer> linkedList = hashMap.get(sss);
                if (linkedList != null) {
                    int listSize = linkedList.size();
                    for (int i = 0; i < listSize; i++) {
                        if (linkedList.get(i) >= Integer.parseInt(q[4])) {
                            System.out.println("정답들 " + sss + " " + linkedList + " " + q[4] + " " + index);
                            answer[index]++;
                        }
                    }
                }
            }
            index++;
        }
        return answer;
    }

}