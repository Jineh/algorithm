package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G20115 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] drink = new int[n];

        for (int i = 0; i < n; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drink);

        double sum =0;

        for (int i = 0; i < n; i++) {
            if(i==n-1){
                sum+=drink[i];
            }
            else{
                sum += (double)drink[i]/2;
            }
        }

        System.out.println(sum);

    }
}
