import java.util.*;

public class P8119 {

    List<List<int[]>> gmap = new ArrayList<>();
    Set<Integer> result = new HashSet<>();

    public void bfs(int idx,int cost, int k){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {idx,cost});
        while (!queue.isEmpty()){
            int[] tem = queue.poll();
            int curr = tem[0];
            int total_cost = tem[1];
            List<int[]> list = gmap.get(curr);
            for (int[] tem1 : list) {
                int next = tem1[0];
                int n_cost = tem1[1];
                if (total_cost + n_cost < k) {
                    queue.add(new int[]{next, total_cost + n_cost});
                } else if (total_cost + n_cost == k) {
                    result.add(next);
                }
            }
        }
    }

    public int[] solution(int n, int k, int[][] roads){

        for (int i=0; i<n;i++){
            gmap.add(new ArrayList<>());
        }
        for (int[] road:roads) {
            int a = road[0];
            int b = road[1];
            int c = road[2];
            gmap.get(a).add(new int[] {b,c});
            gmap.get(b).add(new int[] {a,c});
        }

        bfs(0,0,k);

        List<Integer> answer = new ArrayList<>(result);
        int[] real = new int[answer.size()];
        answer.sort(Comparator.naturalOrder());
        for(int i = 0; i < answer.size(); i++){
            real[i] = answer.get(i);
        }

        return real;
    }

    public static void main(String[] args) {
        P8119 p = new P8119();
        System.out.println(Arrays.toString(p.solution(6, 17, new int[][]{{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}})));
    }
}
