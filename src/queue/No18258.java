package queue;
import java.io.*;

class baekjoon18258 {
    public void No18258() throws NumberFormatException, IOException {
        baekjoon18258.Queue<Integer> stack = new baekjoon18258.Queue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int result;
            switch (str[0]) {
                case "front":
                    result = stack.front();
                    bw.write(result + "\n");
                    break;
                case "back":
                    result = stack.back();
                    bw.write(result + "\n");
                    break;
                case "pop":
                    result = stack.pop();
                    bw.write(result + "\n");
                    break;
                case "empty":
                    result = stack.empty();
                    bw.write(result + "\n");
                    break;
                case "size":
                    result = stack.size();
                    bw.write(result + "\n");
                    break;
                case "push":
                    stack.push(Integer.parseInt(str[1]));
                    //bw.write(result+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
    public class Queue<Integer> {

        class Node<Integer> {
            private int data;
            private Node<Integer> next;

            public Node(int data) {
                this.data = data;
            }
        }
        private int size=0;
        private Node<Integer> front;
        private Node<Integer> back;

        public void push(int item) {
            Node<Integer> t = new Node<Integer>(item);
            this.size++;
            if (back != null) {
                back.next = t;
            }
            back = t;
            if (front == null) {
                front = back;
            }
        }
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
//            int count = 0;
//            Node<Integer> t = front;
//            while (t != null){
//                t=t.next;
//                count++;
//            }
            return this.size;
        }
    }
}

public class No18258 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon18258().No18258();
    }
}
