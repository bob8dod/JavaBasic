import java.util.*;
/*
인덱스길이의 특징을 살려서 linkedlist 처럼 표현함.
2차원 배열 정렬 시, 정렬 method를 overriding 하여 새로 만듦.
좀 복잡하게 푼 버전
*/
public class P42840 {
    public int[] solution(int[] answers) {
        int[] p1 = { 1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[][] correct = new int[][] {{1,0},{2,0},{3,0}};
        ArrayList<Integer> tem = new ArrayList<>();

        for(int i =0; i<answers.length; i++){
            int i1 = i % p1.length;
            int i2 = i % p2.length;
            int i3 = i % p3.length;

            if(answers[i] == p1[i1]) correct[0][1]++;
            if(answers[i] == p2[i2]) correct[1][1]++;
            if(answers[i] == p3[i3]) correct[2][1]++;
        }


        Arrays.sort(correct, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o2[1])* -1;
            }
        });

        int max = correct[0][1];
        for(int k = 0; k< 3; k++){
            if(correct[k][1] == max) tem.add(correct[k][0]);
        }

        int[] answer = new int[tem.size()];
        for(int i = 0; i< tem.size(); i++) answer[i] = tem.get(i);
        return answer;
    }

    public static void main(String[] args) {
        P42840 p = new P42840();
        int[] co = p.solution(new int[] {1,2,3,4,5});
        for(int i : co) System.out.print(i + " ");
    }
}
