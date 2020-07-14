package stack;
import java.io.*;
class test {
    public void asdf()throws NumberFormatException, IOException {
        test.Stack<Integer> stack = new test.Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int result;
            switch (str[0]){
                case "top" :
                    result = stack.top();
                    //System.out.println(result);
                    bw.write(result+"\n");
                    break;
                case "pop" :
                    result = stack.pop();
                    //System.out.println(result);
                    bw.write(result+"\n");
                    break;
                case "empty" :
                    result = stack.empty();
                    //System.out.println(result);
                    bw.write(result+"\n");
                    break;
                case "size" :
                    result = stack.size();
                    //System.out.println(result);
                    bw.write(result+"\n");
                    break;
                case "push" :
                    stack.push(Integer.parseInt(str[1]));
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
    public class Stack<Integer> {
        class Node<Integer> {
            private int data; //데이터
            private Node<Integer> next; // 다음 노트의 위치

            public Node(int data) {
                this.data = data;
            }
        }

        // private T top;
        private Node<Integer> top;

        public int pop() {
            if (top == null) {
                return -1;
            }
            int item = top.data;
            top = top.next;
            return item;
        }

        public void push(int item) {
            Node<Integer> s = new Node<Integer>(item);
            s.next = top;
            top = s;
        }

        public int top() {
            if (top == null) {
                return -1;
            } else {
                return top.data;
            }
        }

        public int empty() {
            if (top == null) {
                return 1;
            } else {
                return 0;
            }
        }

        public int size() {
            int count = 0;
            Node<Integer> s = top;
            while (s != null) {
                s = s.next;
                count++;
            }
            return count;
        }
    }
}
public class No10828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new test().asdf();
    }
}
