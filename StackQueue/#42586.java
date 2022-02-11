package algorithm.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class P42586 {

    static int[] solution(int[] progresses, int[] speeds){

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> ll_p = new LinkedList<>(); // Queue를 인덱스로 접근하기 위해 LinkedList로 구현
        LinkedList<Integer> ll_s = new LinkedList<>(); // Queue를 인덱스로 접근하기 위해 LinkedList로 구현
 
        for(int i : progresses) ll_p.add(i);
        for(int i : speeds) ll_s.add(i);

        while(!ll_p.isEmpty()){
            int cnt = 0;
            while(!ll_p.isEmpty() && ll_p.peek() >= 100) {
                ll_p.removeFirst();
                ll_s.removeFirst();
                cnt++;
            }
            if(cnt > 0) list.add(cnt);
            for(int i = 0; i<ll_p.size(); i++) ll_p.set(i, ll_p.get(i) + ll_s.get(i));
        }

        int[] answer;
        answer = list.stream().mapToInt(i->i).toArray();
        // toArray는 integer로 바로 적용이 불가. so, 위의 방식 or for문 이용
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        for(int i : answer) System.out.print(i + " ");
    }
}
