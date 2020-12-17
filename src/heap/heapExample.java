package heap;

import java.io.*;
import java.util.ArrayList;


class test {
    public void No1966() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        minHeap min = new minHeap();
        maxHeap max = new maxHeap();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                bw.write(max.delete() + "\n");
            } else {
                max.insert(number);
            }

        }

        bw.flush();
        bw.close();
    }

    public static class maxHeap {
        private ArrayList<Integer> heap;

        // 힙을 생성합니다.
        public maxHeap() {
            heap = new ArrayList<>();
            heap.add(0); // 힙은 항상 0이상부터 시작하기 때문에 임의값 0을 미리 넣어둡니다.
        }

        // Insert
        public void insert(int data) throws IOException {
            heap.add(data);
            int n = heap.size() - 1;// 0은 그냥 넣어둔거니까 1을 빼서 size를 체크합니다.
           /*
           부모노드를 기준으로 왼쪽은 *2
           부모노드를 기준으로 오른쪽은 *2 +1 의 index를 갖는다.
            */
            while (n > 1 && heap.get(n / 2) < heap.get(n)) {
                // 부모 노드가 자식의 노드보다 더 작으면 조건문을 만족하고 교체됩니다.
                int tmp = heap.get(n / 2);
                heap.set(n / 2, heap.get(n));
                heap.set(n, tmp);
                n = n / 2; //부모 노드의 위치로 변경
//                System.out.println("변경하는 노드위치n"+n);
            }
//            System.out.println("n"+n);
//            System.out.println("data"+data);
        }

        //Delete
        public int delete() {
            //비어있으면 그냥 끝낸다.
            if (heap.size() == 1) {
                return 0;
            }
            // 항상삭제는 제일위의 root node를 한다.
            // 그리고 root는 항상 1이다.
            int root = heap.get(1);

            // root에 가장 마지막에 추가된 노드의 값을 넣고 삭제
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int index = 1; //시작기준
            int tmpData, tmp;

            //자식노드가 존재하면 루플르 돈다.
            // -1 해줘야 헛도는걸 방지한다.
            while (index * 2 < heap.size() - 1) {
                int left = index * 2;
                int right = index * 2 + 1;
                // 양쪽의 자식노드가 모두 존재하고
                // 왼쪽 노드가 오른쪽 보다 크다면
                // 루트로 올라가야되는건 더 작은 오른쪽이지
                if ((right < heap.size()) && (heap.get(left) < heap.get(right))) {
                    tmp = right;
                } else {
                    // 왼쪽만 존재하거나
                    // 왼쪽 노드가 더 작다면
                    tmp = left;
                }

                tmpData = heap.get(tmp);
                heap.set(tmp, heap.get(index));
                heap.set(index, tmpData);
                if (heap.get(index) < tmpData)
                    break;
                else
                    index = tmp;

            }
            return root;
        }
    }

    public static class minHeap {
        private ArrayList<Integer> heap;

        // 힙을 생성합니다.
        public minHeap() {
            heap = new ArrayList<>();
            heap.add(0); // 힙은 항상 0이상부터 시작하기 때문에 임의값 0을 미리 넣어둡니다.
        }

        // Insert
        public void insert(int data) throws IOException {
            heap.add(data);
            int n = heap.size() - 1;// 0은 그냥 넣어둔거니까 1을 빼서 size를 체크합니다.
           /*
           부모노드를 기준으로 왼쪽은 *2
           부모노드를 기준으로 오른쪽은 *2 +1 의 index를 갖는다.
            */
            while (n > 1 && heap.get(n / 2) > heap.get(n)) {
                // 부모 노드가 자식의 노드보다 더 작으면 조건문을 만족하고 교체됩니다.
                int tmp = heap.get(n / 2);
                heap.set(n / 2, heap.get(n));
                heap.set(n, tmp);
                n = n / 2; //부모 노드의 위치로 변경
            }
        }

        //Delete
        public int delete() {
            //비어있으면 그냥 끝낸다.
            if (heap.size() == 1) {
                return 0;
            }
            // 항상삭제는 제일위의 root node를 한다.
            // 그리고 root는 항상 1이다.
            int root = heap.get(1);

            // root에 가장 마지막에 추가된 노드의 값을 넣고 삭제
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int index = 1; //시작기준
            int tmpData, tmp;

            //자식노드가 존재하면 루플르 돈다.
            // -1 해줘야 헛도는걸 방지한다.
            while (index * 2 < heap.size() - 1) {
                int left = index * 2;
                int right = index * 2 + 1;
                if ((right < heap.size()) && (heap.get(left) > heap.get(right))) {
                    tmp = right;
                } else {
                    // 왼쪽만 존재하거나
                    // 왼쪽 노드가 더 작다면
                    tmp = left;
                }
                tmpData = heap.get(tmp);
                heap.set(tmp, heap.get(index));
                heap.set(index, tmpData);
                if (heap.get(index) < tmpData)
                    break;
                else
                    index = tmp;
            }
            return root;
        }
    }

}
public class heapExample {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new test().No1966();
    }
}
