package greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G20300 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] loss = new long[n];
        for(int i =0; i<n; i++){
            loss[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(loss);
        long sum = loss[n-1];

        if(loss.length%2==0){
            for(int i=0; i<n/2; i++){
                long value = loss[i] + loss[n -1 -i];
                if(sum < value) sum = value;
            }
        }
        else{
            for(int i=0; i< n/2; i++){
                long value = loss[i] + loss[n -2 -i];
                if(sum < value) sum = value;
            }
        }
        System.out.println(sum);
    }
}
