package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G17521 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long coin =0;
        int[] chart = new int[n];
        for(int i=0; i<n; i++){
            chart[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 0; i < n-1; i++) {
            if(chart[i] < chart[i+1]){
                if(w>=chart[i]){
                    coin = w/chart[i];
                    w = w%chart[i];
                }
            }
            else if(chart[i] > chart[i+1]){
                w+= chart[i] * coin;
                coin=0;
            }
        }
        w += coin * chart[n-1];
        System.out.println(w);
    }
}
