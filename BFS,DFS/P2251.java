package algorithm.bfs_dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P2251 {

    int A,B,C;
    boolean[][] visited;
    ArrayList<Integer> result = new ArrayList<>();

    public void dfs(int a, int b, int c){
        if(visited[a][b]) return;
        visited[a][b] = true;
        if(a == 0) result.add(c);

        int water;
        // A -> B
        water = Math.min(a,B-b);
        dfs(a-water, b+water, c);
        // A -> C
        water = Math.min(a, C - c);
        dfs(a - water, b, c+water);
        // B -> A
        water = Math.min(b, A - a);
        dfs(a + water, b - water, c);
        // B -> C
        water = Math.min(b, C - c);
        dfs(a, b - water, c + water);
        // C -> A
        water = Math.min(c, A- a);
        dfs(a + water, b, c - water);
        // C -> B
        water = Math.min(c, B - b);
        dfs(a, b + water, c - water);
    }

    public void solution(int a, int b, int c){
        visited = new boolean[a+1][b+1];
        A = a;
        B = b;
        C = c;
        dfs(0,0,c);
        result.sort(Comparator.naturalOrder());
        for(int i : result){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        P2251 p = new P2251();
        p.solution(a,b,c);
    }
}
