import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3893 {

    int[] origin;
    int min_cnt;
    int[] min_li;
    List<int[]> list = new ArrayList<>();

    public void check(int[] arr, int r, int K) {

        int flag = 1;
        for (int i = 0; i < r-1; i++)
            if (Math.abs(arr[i] - arr[i+1]) > K){
                flag = 0;
            }


        if (flag==0){ return;}

        int cnt = 0;
        for (int i = 0; i < r; i++)
            if (arr[i] != origin[i]){
                cnt+=1;
            }
        if(cnt < min_cnt){
            min_cnt = cnt;
            min_li = arr.clone();
        }
    }

    public void permutation(int[] arr, int depth, int n, int r, int K) {
        if (depth == r) {
            check(arr, r, K);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r, K);
            swap(arr, depth, i);
        }
    }

    public void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public int solution(int[] numbers, int K){
        int[] checking = Arrays.stream(numbers).sorted().toArray();
        for (int i =0; i<checking.length; i++){
            if(Math.abs(checking[i+1] - checking[i]) > K) {return -1;}
        }
        origin = numbers.clone();
        min_cnt = numbers.length;
        min_li = numbers.clone();
        permutation(numbers, 0, numbers.length, numbers.length, K);
        return min_cnt-1;
    }




    public static void main(String[] args) {
        P3893 p = new P3893();
        System.out.println(p.solution(new int[] {3, 7, 2, 8, 6, 4, 5, 1}, 3));
    }

}
