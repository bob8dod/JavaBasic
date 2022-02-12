/*
겹치는 원소를 찾기 위해 HashSet을 이용.
차집합을 구하기 위해 기존의 set을 복사해서 사용. (retainAll -> 차집합 구하는 메서드, inPlace)

*/
import java.util.HashSet;
import java.util.Iterator;

public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3;

        for(int i : lost) set1.add(i);
        for(int i : reserve) set2.add(i);
        set3= (HashSet) set2.clone();
        set3.retainAll(set1);

        if(set3.size() != 0){
            Iterator<Integer> itr = set3.iterator();
            while(itr.hasNext()){
                int tem = itr.next();
                set1.remove(tem);
                set2.remove(tem);
            }
        }
        int cnt = 0;
        for(int i = 1; i<=n;i++){
            if(set1.contains(i)){
                if(set2.contains(i-1)){
                    set2.remove(i-1);
                }
                else if(set2.contains(i+1)){
                    set2.remove(i+1);
                }
                else{
                    cnt++;
                }

            }
        }

        return n-cnt;
    }

    public static void main(String[] args) {
        P42862 p = new P42862();
        System.out.println(p.solution(5, new int[] {2, 4}, new int[]{1, 3, 5}));
    }
}
