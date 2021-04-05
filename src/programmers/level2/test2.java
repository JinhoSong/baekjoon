package programmers.level2;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class test2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int rows = 100, columns = 97;
        int[][] queries = {{1,1,100,97}};
//        int rows = 6, columns = 6;
//        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        //result { 3,5}
        System.out.println((Arrays.toString(solution(rows, columns, queries))));

    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int index = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                hashMap.put(index, index++);
            }
        }
        // 2 2 5 4 일 경우
        // (x1-1) *  cols + y1부터 (x1-1)*cols + y2
        // 6 + 2 부터 6 + 4 까지 -> 오른쪽 이동

        index = 0;
        for (int[] a : queries) {
            int x1 = a[0];
            int y1 = a[1];
            int x2 = a[2];
            int y2 = a[3];
            int min = 10001;
            //2 1 10 9

            int start = (x1 - 1) * columns + y1;
            int end = (x1 - 1) * columns + y2;
            int before = hashMap.get(start);

            for (int i = start; i < end; i++) {
                int check = hashMap.getOrDefault(i + 1,0);// 바꿀 인덱스의 값을 꺼내고
                if(min > before)
                    min = before;
                hashMap.put(i + 1, before); // 8-> 9
                before = check; // 다음에 넣기 위해 저장
            }
            // 10 16 22 28
            start = end; //마지막 시점에 시작
            end = (x2 - 1) * columns + y2;
            // (5-1)*6 + y2

            for (int i = start; i < end; i += columns) {
                int check = hashMap.getOrDefault(i + columns,0);// 바꿀 인덱스의 값을 꺼내고
                if(min > before)
                    min = before;
                hashMap.put(i + columns, before); // 8-> 9
                before = check; // 다음에 넣기 위해 저장
            }

            start = end;
            end = (x2 - 1) * columns + y1;
            //28 -> 26
            // (5-1)*6 +y1

            for (int i = start; i > end; i--) {
                int check = hashMap.getOrDefault(i - 1,0);// 바꿀 인덱스의 값을 꺼내고
                if(min > before)
                    min = before;
                hashMap.put(i - 1, before); // 8-> 9
                before = check; // 다음에 넣기 위해 저장
            }

            start = end;
            end = (x1 - 1) * columns + x1;
            // [5,1,6,3]]

            for (int i = start; i > end; i -= columns) {
                int check = hashMap.getOrDefault(i - columns,0);// 바꿀 인덱스의 값을 꺼내고
                if(min > before)
                    min = before;
                hashMap.put(i - columns, before); // 8-> 9
                before = check; // 다음에 넣기 위해 저장
            }

            //26 -> 8
            // (2-1)*6+x1


            for (int i = 1; i <= 36; i++) {
                if (hashMap.get(i) < 10)
                    System.out.print(hashMap.get(i) + "  ");
                else
                    System.out.print(hashMap.get(i) + " ");
                if (i % 6 == 0)
                    System.out.println("");
            }
            answer[index++]=min;
        }

        return answer;
    }

}
