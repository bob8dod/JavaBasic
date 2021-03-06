class Solution {
    public int solution(int[] arr) {
        int min = 10000000;
        int res = 0;
        for(int i = 0; i<=255; i++){
            int less = 0;
            int more = 0;
            for(int j = 0; j<arr.length; j++){
                if (arr[j] < i) {
                    less += 1;
                }
                else if (arr[j] >= i){
                    more += 1;
                }
            }
            int result = Math.abs(less-more);
            if (result < min) {min = result; res = i;}
        }
        return res;
    }
}
