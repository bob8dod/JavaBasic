package algorithm.heap;

import java.util.PriorityQueue;

public class P42626 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) pq.add(i);

        while(pq.peek() < K){
            if(pq.size() == 1) {
                answer = -1;
                return answer;
            }

            int tem = pq.poll() + pq.poll()*2;
            pq.add(tem);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
