import java.util.Arrays;

public class P43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long start =0, end = times[times.length-1]*(long)n;
        long mid, cnt;

        while(start <= end){
            mid = (start + end)/2;
            cnt=0;

            for(int t: times){
                cnt+= mid/t;
            }
            if(cnt < n) start = mid+1;
            else {
                end = mid-1;
                answer = mid;
            }
        }

        return answer;
    }
}
