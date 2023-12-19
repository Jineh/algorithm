import java.util.PriorityQueue;
import java.util.Collections;


public class P12927 {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++) queue.offer(works[i]);

        while(n>0){
            int max = queue.poll();
            if(max==0) break;
            queue.offer(max-1);
            n--;
        }

        while(!queue.isEmpty()){
            int val = queue.poll();
            answer = answer + val * val;
        }

        return answer;
    }
}