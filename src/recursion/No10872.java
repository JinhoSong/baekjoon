package recursion;
import java.io.*;

class baekjoon10866 {
    public void No10866() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new Deque<>();
        int n = Integer.parseInt(br.readLine());
        int number;


        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]){

                case "push_front" :
                    number = Integer.parseInt(str[1]);
                    deque.insertFront(number);
                    break;
                case "push_back" :
                    number = Integer.parseInt(str[1]);
                    deque.insertBack(number);
                    break;
                case "pop_front" :
                    bw.write(deque.deleteFront()+"\n");
                    break;
                case "pop_back" :
                    bw.write(deque.deleteBack()+"\n");
                    break;
                case "size" :
                    bw.write(deque.size()+"\n");
                    break;
                case "empty" :
                    bw.write(deque.isEmpty()+"\n");
                    break;
                case "front" :
                    bw.write(deque.peekFront()+"\n");
                    break;
                case "back" :
                    bw.write(deque.peekBack()+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();

    }
    public static class Deque<Integer>{

        static class DequeNode{
            private final int data;
            DequeNode next;
            DequeNode prev;

            public DequeNode(int data){
                this.data=data;
                next=null;
                prev=null;
            }
        }

        private DequeNode front;
        private DequeNode back;
        private int size = 0;

        public int isEmpty(){
            if(front==null)
                return 1;
            else
                return 0; }

        public void insertFront(int data){
            DequeNode node = new DequeNode(data);
            if(front==null){
                //front가 비어있다면
                front=node;
                back=node;
                node.next=null;
                node.prev=null;
            } else {
                node.next = front;
                node.prev = null;
                front.prev = node;
                front = node;
            }
            this.size++;
        }

        public void insertBack(int data){
            DequeNode node = new DequeNode(data);
            if(back==null){
                //back 비어있다면
                front=node;
                back=node;
                node.next=null;
                node.prev=null;
            } else {
                node.prev = back;
                node.next = null;
                back.next = node;
                back = node;
            }
            this.size++;
        }

        public int size(){
            return this.size;
        }
        public int deleteFront(){
            int result;
            switch (this.size){
                case 0 :
                    return -1;
                case 1 :
                    result= front.data;
                    this.front=null;
                    this.back=null;
                    break;
                default:
                    result= front.data;
                    front.prev=null;
                    this.front=front.next;
                    break;
            }
            this.size--;
            return result;
        }

        public int deleteBack(){

            int result;
            switch (this.size){
                case 0 :
                    return -1;
                case 1 :
                    result= back.data;
                    this.front=null;
                    this.back=null;
                    break;
                default:
                    result= back.data;
                    back.next=null;
                    this.back=back.prev;
                    break;
            }
            this.size--;
            return result;
        }
        public int peekFront(){
            if(front==null)
                return -1;
            else
                return front.data;
        }
        public int peekBack(){
            if(front==null)
                return -1;
            else
                return back.data;
        }
    }
}

public class No10872 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new baekjoon10866().No10866();
    }
}

