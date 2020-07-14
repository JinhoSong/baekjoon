package stack;
import java.io.*;
import java.util.StringTokenizer;
class Stack<T>{
    class Node<T> {
        private T data; //데이터
        private Node<T> next; // 다음 노트의 위치

        public Node(T data) {
            this.data = data;
        }
    }
       // private T top;
        private Node<T> top;
        public T pop(){
            if( top == null) {
                System.out.println(-1);
            }
            T item = top.data;
            top = top.next;
            System.out.println(item);
            return item;
        }
        public void push(T item){
            Node<T> s = new Node<T>(item);
          //  s.data = item;
            s.next = top;
            top = s;
        }
        public void top(){
            if( top == null)
                System.out.println(-1);
            else
                System.out.println(top.data);
        }
        public void empty() {
            if (top == null)
                System.out.println(1);
            else
                System.out.println(0);
        }
        public void size(){
            int count =0;
            Node<T> s = top;
            while(s != null){
                s= s.next;
                count ++;
            }
            System.out.println(count);
        }
}
public class stackMain {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack <Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str){
                case "top" : stack.top(); break;
                case "pop" : stack.pop(); break;
                case "empty" : stack.empty(); break;
                case "size" : stack.size(); break;
                default:
                    stack.push(Integer.parseInt(str.substring(5))); break;
            }
        }
    }
}
