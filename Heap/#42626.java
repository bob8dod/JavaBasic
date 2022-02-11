package algorithm.heap;

import java.util.PriorityQueue;

public class P42626 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // PriorityQueue : 우선순위 큐 -> 값을 넣을 때마다 자동으로 이진트리로 정렬. 가장 위의 값이 최솟값.
        for(int i : scoville) pq.add(i);

        while(pq.peek() < K){
            if(pq.size() == 1) {
                answer = -1;
                return answer;
            }

            int tem = pq.poll() + pq.poll()*2; // poll -> 가장 위의 값을 뽑아내는
            pq.add(tem); // add -> 넣어주면서 이진트리로 정렬해줌.
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
