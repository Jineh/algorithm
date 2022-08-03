package greedy;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];
        for(int i=0; i<n; i++){
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        long sum=0;
        for(int i=0; i<n; i++){
            sum+=Math.abs(i+1 - level[i]);
        }

        System.out.println(sum);
    }
}
