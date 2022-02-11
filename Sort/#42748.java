package algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class P42748 {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int[] command : commands){
            int size = command[1] - command[0] + 1;
            int[] tem = new int[size];
            int j = 0;
            for(int i = command[0]-1; i<command[1]; i++, j++){
                tem[j] = array[i];
            }
            arr.add(Arrays.stream(tem).sorted().toArray()[command[2] - 1]);
        }
//        System.out.println(arr);
        int[] answer= arr.stream().mapToInt(i->i).toArray(); // ArrayList를 일반 list로 바꿔주는 방법
        return answer;
    }

    public static void main(String[] args) {
        P42748 p = new P42748();
        p.solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}
