package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P11448 {

    static HashMap<Integer, ArrayList<Integer>> graph= new HashMap<>();
    static int[] pass;
    static int[] result;

    public static void dfs(int curr, int total, int prev){

        result[curr] = total;

        for(int next : graph.getOrDefault(curr, new ArrayList<>())){
            if(next != prev) dfs(next, total + pass[next-1], curr);
        }
    }

    public static int[] solution(int n, int[] passenger, int[][] train) {
        pass = passenger.clone();
        result = new int[n];
        for(int[] tem : train){
            ArrayList<Integer> temList;
            temList = graph.getOrDefault(tem[0]-1, new ArrayList<>());
            temList.add(tem[1]-1);
            graph.put(tem[0]-1,temList);

            ArrayList<Integer> temList2;
            temList2 = graph.getOrDefault(tem[1]-1, new ArrayList<>());
            temList2.add(tem[0]-1);
            graph.put(tem[1]-1,temList2);
        }


        dfs(0, passenger[0], -1);
        int max = Arrays.stream(result).max().getAsInt();
        int[] answer = new int[2];
        for(int i = n-1; i>=0; i--){
            if(result[i] == max) {answer[0] = i+1; answer[1] = max; break;}
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = solution(6,new int[]{1,1,1,1,1,1},new int[][] {{1,2},{1,3},{1,4},{3,5},{3,6}});
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
