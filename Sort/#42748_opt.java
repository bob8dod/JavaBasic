package algorithm.sort;

import java.util.Arrays;

public class P42748_opt {
    public int[] solution(int[] array, int[][] commands) {
       int[] answer = new int[commands.length];
       for(int n=0; n<commands.length; n++) {
           int i = commands[n][0] - 1, j = commands[n][1], k = commands[n][2] - 1;
           int[] temp = Arrays.copyOfRange(array, i, j); //리스트를 복사해오는데, 정해진 범위로 복사해오는 Arrays의 method
           Arrays.sort(temp); // Arrays에서 제공하는 sort메서드 -> 주어진 배열을 정렬해줌 / 반환X, inPlace
           answer[n] = temp[k];
       }
       return answer;
    }

    public static void main(String[] args) {
        P42748_opt p = new P42748_opt();
        p.solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}
