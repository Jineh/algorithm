package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2212 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensor = new int[n];
        int[] diff = new int[n-1];

        if(k>=n){
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensor[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        for(int i=0; i<n-1; i++){
            diff[i] = sensor[i+1] -sensor[i];
        }

        Arrays.sort(diff);
        int res =0;
        for(int i=0; i<n-k; i++){
            res +=diff[i];
        }

        System.out.println(res);
    }
}
