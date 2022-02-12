public class P42898 {
 
    final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] gmap = new int[n][m];
        int[][] dp = new int[n][m];

        for(int[] pud : puddles) gmap[pud[1]-1][pud[0]-1] = -1;
        for(int i = 0; i <n; i++) {
            if(gmap[i][0] == -1) break;
            dp[i][0] = 1;
        }
        for(int j = 0; j <m; j++) {
            if(gmap[0][j] == -1) break;
            dp[0][j] = 1;
        }

        for(int i =1;i<n;i++){
            for(int j = 1; j < m; j++){
                if(gmap[i][j] != -1){
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD;
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        P42898 p = new P42898();
        System.out.println(p.solution(4,3,new int[][] {{2,2}}));
    }
}
