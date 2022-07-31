package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum=0;
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            sum += b[i];
        }

        int cnt =0;
        while(sum!=0){
            int num =0;
            for(int i=0; i<n; i++){
                if(b[i]%2==1){
                    b[i]--;
                    num++;
                }
            }
            if(num>0){
                sum -= num;
                cnt += num;
            }
            else{
                for(int i=0; i<n; i++) {
                    b[i] /= 2;
                }
                sum/=2;
                cnt++;
                }
            }
        System.out.println(cnt);
    }
}
