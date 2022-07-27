package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            h[i]=Integer.parseInt(st.nextToken());
        }

        int cnt=0;
        int s=0;
        int j=0;
        for(int i=0; i<n; i++){
            if(h[i]!=0){
                j=i;
                cnt++;
                s=--h[i];
                while(s>0 && j<n-1){
                    j++;
                    if(h[j]==s) {
                        s--;
                        h[j]=0;
                    }
                }
                h[i]=0;
            }
        }
        System.out.println(cnt);
    }
}
