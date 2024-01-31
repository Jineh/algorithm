import java.util.Arrays;
import java.util.PriorityQueue;

public class P42627 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx=0, end=0, cnt=0;
        Arrays.sort(jobs, (a1, a2) -> (a1[0] - a2[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> (a1[1] - a2[1]));

        while(cnt<jobs.length){

            while(idx < jobs.length && jobs[idx][0] <= end){
                pq.offer(jobs[idx++]);
            }

            if(pq.isEmpty()){
                end = jobs[idx][0];
            }
            else{
                int[] tmp = pq.poll();
                answer += tmp[1] + end - tmp[0];
                end+=tmp[1];
                cnt++;
            }
        }
        return (int) Math.floor(answer/idx);

    }
}
