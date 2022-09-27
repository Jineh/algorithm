package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> positiveQ = new PriorityQueue<>((p1, p2) -> p2 - p1);
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>((p1, p2) -> p2 - p1);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());

            if(temp>0){
                positiveQ.add(temp);
            } else{
                negativeQ.add(Math.abs(temp));
            }
        }

        int max = 0;
        if(positiveQ.isEmpty()){
            max = negativeQ.peek();
        }else if(negativeQ.isEmpty()){
            max = positiveQ.peek();
        }else{
            max = Math.max(positiveQ.peek(), negativeQ.peek());
        }

        int ans =0;

        while(!positiveQ.isEmpty()){
            int temp = positiveQ.poll();
            for(int i=0; i<m-1; i++){
                positiveQ.poll();

                if(positiveQ.isEmpty()) break;
            }
            ans += temp *2;
        }

        while(!negativeQ.isEmpty()){
            int temp = negativeQ.poll();
            for(int i=0; i<m-1; i++){
                negativeQ.poll();

                if(negativeQ.isEmpty()) break;
            }
            ans += temp*2;
        }

        System.out.println(ans-max);
    }
}
