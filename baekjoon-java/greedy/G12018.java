package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cs = new int[n];
        int cnt =0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] mile = new int[a];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<a; j++){
                mile[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(mile);
            if(a>=b){
               cs[i] = mile[a-b];
            }
            else{
                cs[i] = 1;
            }

        }
        Arrays.sort(cs);
        for(int i=0; i<n; i++){
            if(m-cs[i]>=0){
                m-=cs[i];
                cnt++;
            }
            else break;
        }


        System.out.println(cnt);
    }
}
