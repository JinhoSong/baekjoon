package programmers.level2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class truckBridge {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int bridge_length =2;
        int weight=10;
        int [] truck_weights = {7,4,5,6};
        System.out.println(solution(bridge_length, weight,truck_weights));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 길이 -> 걸리는 시간
        // 무게 -> 최대 무게

        Queue<Node> queue = new LinkedList<>();
        LinkedList<Node> list = new LinkedList<>();
        for(int val : truck_weights){
            queue.add(new Node(0,val));
        }
        int sum = 0;
        int answer = 0;
        while(!queue.isEmpty()){

            if(!list.isEmpty()){
                // 리스트에 값이 있는 경우

                int size = list.size();
                int local = 0;
                for(int i=0;i<size;i++){
                    Node node  = list.get(i-local);
                    node.setTime(node.getTime()+1);
                    // System.out.println(i+" " +node.getTime());
                    if(node.getTime() == bridge_length){
                        list.remove();
                        sum=sum - node.getWeights();
                        local++;
                    } else {
                        list.set(i-local,node);
                    }
                }
            }

            // 리스트에 값을 더하는 로직
            // 0 7 7 4 9 5 6 6 0
            //System.out.println(sum);
            if(sum+queue.peek().getWeights() <= weight){
                // 큐의 맨 앞 값을 더해도 무게를 초과하지 않는 경우
                Node node = queue.poll();
                node.setTime(node.getTime());
                sum = sum + node.getWeights();
                list.add(node);
            }
            //System.out.println(sum);
            answer++;
        }

        return answer+bridge_length;
    }
    static class Node{
        int time;
        int weights;

        public Node(int time,int weights){
            this.time=time;
            this.weights=weights;
        }

        public int getTime(){
            return this.time;
        }

        public int getWeights(){
            return this.weights;
        }

        public void setTime(int time){
            this.time=time;
        }
        public void setWeights(int weights){
            this.weights=weights;;
        }
    }
}




