package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G13305 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] road = new long[n - 1];
        long[] coin = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            coin[i] = Long.parseLong(st.nextToken());
        }


        long sum = 0;
        long min = coin[0];

        for (int i = 0; i < n - 1; i++) {

            if(coin[i]<min){
                min=coin[i];
            }

            sum+= (min * road[i]);
        }

        System.out.println(sum);
    }
}


