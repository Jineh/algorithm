package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer bf = new StringBuffer();

        while(t-- >0){
            int n = Integer.parseInt(br.readLine());
            int [] cycle = new int[n+1];
            int [] check = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                cycle[i] = Integer.parseInt(st.nextToken());
            }

            int cnt=0, next, start;
            for(int i=1; i<=n; i++){
                if(check[i] == 1) continue;

                start = i;
                next =i;

                while(true) {
                    if (start == next && check[next] ==1) {
                        cnt++;
                        break;
                    } else {
                        check[next] =1;
                        next = cycle[next];
                    }
                }


            }
            bf.append(cnt);
            bf.append("\n");

        }
        System.out.println(bf);
    }
}
