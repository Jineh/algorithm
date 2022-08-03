package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G16162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] song = new int[n];
        for(int i=0; i<n; i++){
            song[i] = Integer.parseInt(st.nextToken());
        }

        int next = a;
        int cnt =0;
        for(int i=0; i<n; i++){
            if(song[i]==next){
                cnt++;
                next = d*cnt + a;
            }
        }

        System.out.println(cnt);
    }
}
