/*
굳이 새로운 set을 만들 필요 없이
하나의 set만을 이용해서 처리.
모든 반복문 및 구현을 도둑 맞은 사람을 기준으로 실행. -> 효율적
*/
import java.util.HashSet;
import java.util.Iterator;

public class P42862_opt {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        HashSet<Integer> rset = new HashSet<>();
        for(int r : reserve) rset.add(r);

        for(int i = 0; i < lost.length; i++){
            if(rset.contains(lost[i])){
                rset.remove(i);
                lost[i] = 0;
            }
        }

        for(int lp : lost){
            if (lp==0) {
                answer++;
            }

            else if(rset.contains(lp-1)){
                rset.remove(lp-1);
                answer++;
            }
            else if(rset.contains(lp+1)){
                rset.remove(lp+1);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P42862_opt p = new P42862_opt();
        System.out.println(p.solution(5, new int[] {2, 4}, new int[]{1, 3, 5}));
    }
}
