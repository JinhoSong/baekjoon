package queue;

import java.io.*;

// 실패작
class baekjoon1966failed {
    public void No1966() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        myQueue<Integer> queue = new myQueue<>();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            queue.clear();
            String[] str = br.readLine().split(" ");
            int number = Integer.parseInt(str[0]);
            int result = Integer.parseInt(str[1]); // 중요한 인덱스 자리
            str = br.readLine().split(" "); // 우선순위 한 줄을 읽고
            for (int j = 0; j < number; j++) {
                if (number == 1) {
                    count++;
                    break;
                }
                int input = Integer.parseInt(str[j]);
                while (queue.back() > input) {
                    int outIndex = queue.index();
                    int outData = queue.pop();
                    queue.push(outData, outIndex);
                    System.out.println("test" + outData + " " + outIndex);
                    System.out.println("testinput" + input);

                }// 젤 위보다 입력값이 작으면 다 뽑아내서 넣고

                queue.push(input, j); //일단 우선순위랑 인덱스를 큐에 다 넣었고 이제 정렬을 시켜야 되는데
                while (queue.back() <= queue.front() && queue.size() >2) {
                    int outIndex = queue.index();
                    int outData = queue.pop();
                    queue.push(outData, outIndex);

                }
                System.out.println("완료시front" + queue.front());
                System.out.println("완료시back" + queue.back());

            }
            while (queue.index() != result && queue.size() != 0) {
                queue.pop();
                count++;
            }
            System.out.println(count + "<< 이거 몇개 \n");

        }
        bw.flush();
        bw.close();
    }

    public class myQueue<Integer> {

        class Node<Integer> {
            private int data;
            private int index;
            private Node<Integer> next;

            public Node(int data, int index) {
                this.data = data;
                this.index = index;
            }
        }

        private int size = 0;
        private Node<Integer> front;
        private Node<Integer> back;

        public void push(int item, int index) {
            Node<Integer> t = new Node<Integer>(item, index);
            this.size++;
            if (back != null) {
                back.next = t;
            }
            back = t;
            if (front == null) {
                front = back;
            }
        }

        public void clear() {
            if (front == null) {
                return;
            }
            this.size = 0;
            front = null;
            back = null;
        }

        public int index() {
            if (front != null)
                return front.index;
            else
                return -1;
        } //해당 인덱스를 저장

        public int pop() {
            if (front == null)
                return -1;
            int data = front.data;
            front = front.next;

            if (front == null) {
                back = null;
            }
            this.size--;
            return data;
        }

        public int front() {
            if (front == null) {
                return -1;
            }
            return front.data;
        }

        public int back() {
            if (back == null) {
                return -1;
            }
            return back.data;
        }

        public int empty() {
            if (front == null)
                return 1;
            else
                return 0;
        }

        public int size() {
            return this.size;
        }
    }
}

public class No1966failed {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon1966failed().No1966();
    }
}
