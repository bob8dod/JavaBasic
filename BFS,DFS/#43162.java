import java.util.*;

public class P43162 {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] visited;
    public void bfs(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        while(!queue.isEmpty()){
            List<Integer> list;
            int curr = queue.poll();
            list = map.get(curr);
            for(int i = 0; i< list.size();i++ ){
                int next = list.get(i);
                if(visited[next] == 0){
                    queue.add(next);
                    visited[next] = 1;
                }
            }
        }
    }


    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];

        for(int i = 0; i<computers.length; i++){
            LinkedList<Integer> tem = new LinkedList<>();
            for(int j = 0; j<computers[i].length; j++){
                if(i != j && computers[i][j] == 1){
                    tem.add(j);
                }
            }
            map.put(i,tem);
        }

        for(int i = 0; i< n; i++){
            if(visited[i] == 0) {
                bfs(i);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P43162 p = new P43162();
        System.out.println(p.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
