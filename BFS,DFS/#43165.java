public class P43165 {

    int[] nums;
    int tar;
    int cnt = 0;

    public void dfs(int res, int idx){
        if(idx == nums.length){
            if(res == tar) cnt++;
            return;
        }

        dfs(res - nums[idx], idx + 1);
        dfs(res + nums[idx], idx + 1);
    }

    public int solution(int[] numbers, int target) {
        nums = numbers.clone();
        tar = target;
        dfs(0, 0);
        return cnt;
    }

    public static void main(String[] args) {
        P43165 p = new P43165();
        System.out.println(p.solution(new int[] {4, 1, 2, 1}, 4));
    }
}
