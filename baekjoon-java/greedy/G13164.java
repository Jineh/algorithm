package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] person = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[n-1];
        for(int i=0; i<n-1; i++){
            diff[i] = person[i+1] - person[i];
        }

        Arrays.sort(diff);

        int res =0;
        for(int i=0; i<n-k; i++){
            res += diff[i];
        }

        System.out.println(res);
    }
}
