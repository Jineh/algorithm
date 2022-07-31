package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];

        for(int i=0; i<n; i++){
            level[i] = Integer.parseInt(br.readLine());
        }

        int min =level[n-1];
        int cnt =0;
        for(int i=n-2; i>=0; i--){
            while(level[i]>=min){
                level[i]--;
                cnt++;
            }
            min = level[i];
        }
        System.out.println(cnt);
    }
}
