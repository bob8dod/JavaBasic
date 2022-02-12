import java.util.*;
/*
애초에 새로운 트리를 만들어서 비교할 필요가 없었음. -> 새로운 트리 만들때 시간, 메모리가 아까움!
기존에 주어진 배열로 충분히 판단 가능!!!
*/
public class P43162_opt {

    boolean[] visited;

    public void bfs(int idx, int[][] computers){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i = 0; i< computers[curr].length;i++ ){
                if(i == curr || computers[curr][i] == 0) continue;
                if(!visited[i]){
                    queue.add(i);
                    System.out.println(i);
                    visited[i] = true;
                }
            }
        }
    }


    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0; i< n; i++){
            if(!visited[i]) {
                visited[i] = true;
                bfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P43162_opt p = new P43162_opt();
        System.out.println(p.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
