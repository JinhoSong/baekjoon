package sorting;

import java.io.*;
import java.util.Arrays;

class sorting {
    public void sort() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int[] arr = {27, 10, 12, 20, 25, 13, 15, 22};
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2};
        merge_sorting(arr, 0, arr.length - 1);
        bw.write("최종결과 : " + Arrays.toString(arr));
        bw.flush();
        bw.close();
    }

    public void merge(int[] list, int left, int mid, int right) {
        int i = left; // 정렬된 왼쪽 리스트에 대한 인덱스
        int j = mid + 1; // 정렬된 오른쪽 리스트에 대한 인덱스
        int k = left; // 정렬될 리스트에 대한 인덱스
        int[] sorted = new int[list.length];

        while (i <= mid && j <= right) {
            if (list[i] <= list[j])
                sorted[k++] = list[i++];
            else
                sorted[k++] = list[j++];
            // 큰쪽을 sorted 배열에 삽입하고 index를 ++시킨다.
        }
        // 남아 있는 값들을 일괄 복사한다.
        if (i > mid) {
            // i가 mid 보다 크면 right가 남아 있는거니깐 j 부터 right까지 남은걸 더하고
            for (int p = j; p <= right; p++) {
                sorted[k++] = list[p];
            }
        } else {
            // i 가 mid 보다 작으면 left가 남아 있는거니깐 i 부터 mid까지 남은걸 더한다
            for (int p = i; p <= mid; p++) {
                sorted[k++] = list[p];
            }
        }
        // 임시배열 sorted를 list에 복사한다.
        for (int p = left; p <= right; p++)
            list[p] = sorted[p];
        System.out.println(Arrays.toString(list));
    }

    public void merge_sorting(int[] list, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2; // 중간 위치를 계산하여 리스트를 균등 분할
            merge_sorting(list, left, mid); // 재귀로 자기 자신을 호출하는데 left < right 즉, 1 < 1 일때까지 반복적으로 호출 된다.
            merge_sorting(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
}

public class MergeSort {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new sorting().sort();
    }
}
