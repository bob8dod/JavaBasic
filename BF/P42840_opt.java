import java.util.*;
/*
정렬 메소드를 새로 정의해서 할 필요없이
max값을 구해서 max값과 똑같은 얘를 체크한 버전. -> Arrays.stream(arr).max.getAsInt();
훨씬 효율적이고 빠르게 작성 가능.
*/
public class P42840_opt {
    public int[] solution(int[] answers) {
        int[] p1 = { 1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correct = new int[3];
        for(int i =0; i<answers.length; i++) {
            int i1 = i % p1.length;
            int i2 = i % p2.length;
            int i3 = i % p3.length;

            if(answers[i] == p1[i1]) correct[0]++;
            if(answers[i] == p2[i2]) correct[1]++;
            if(answers[i] == p3[i3]) correct[2]++;
        }

        int max = Arrays.stream(correct).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<correct.length; i++){
            if(correct[i] == max) list.add(i+1);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i< list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

    public static void main(String[] args) {
        P42840_opt p = new P42840_opt();
        int[] co = p.solution(new int[] {1,2,3,4,5});
        for(int i : co) System.out.print(i + " ");
    }
}
