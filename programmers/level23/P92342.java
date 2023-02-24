import java.util.Arrays;

public class P92342 {
    static int max=-1;
    static int[] res= {-1};
    public static int[] solution(int n, int[] info) {
        if(n==1 && info[0]==1) return res;
        int [] r_arr = new int[11];
        find(info, 1, n, r_arr);
        return res;
    }

    static void find(int[] info, int cnt, int n, int[] r_arr){
        if(cnt == n+1){
            int sum =0;
            int r_sum=0;
            for(int i=0; i<=10; i++){
                if(info[i]!=0 || r_arr[i]!=0){
                    if(info[i]<r_arr[i]) r_sum += (10-i);
                    else sum+=(10-i);
                }
            }
            if(r_sum>sum){
                if(r_sum - sum >= max){
                    res = r_arr.clone();
                    max = r_sum-sum;
                }
            }
            return;
        }

        for(int j=0; j<=10 && r_arr[j]<=info[j]; j++){
            r_arr[j]++;
            find(info, cnt+1, n, r_arr);
            r_arr[j]--;
        }
    }

    public static void main(String[] args) {
        int n= 3;
        int[] b = {0,0,0,0,0,0,0,0,3,4,3};
        System.out.println(Arrays.toString(P92342.solution(n, b)));
    }
}
