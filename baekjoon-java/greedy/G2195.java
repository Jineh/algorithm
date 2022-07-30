package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        int idx =0;
        int cnt =0;
        for(int i=0; i<p.length(); i++){
            int check = s.indexOf(p.substring(idx, i+1));
            if( check != -1) continue;

            cnt++;
            idx =i;
        }
        System.out.println(cnt+1);
    }
}
