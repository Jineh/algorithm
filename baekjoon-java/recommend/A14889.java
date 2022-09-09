package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A14889 {
    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n];

        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0);
        System.out.println(min);
    }

    static void solve(int idx, int cnt){
        if(cnt==n/2){

            diff();
            return;
        }

        for(int i=idx; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                solve(i+1, cnt+1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int s = 0, l = 0;

        for (int i = 0; i < n - 1; i++) {
            for(int j=i+1; j<n; j++){

                if(visit[i]==true && visit[j]==true){
                    s+=arr[i][j];
                    s+=arr[j][i];
                }
                else if(visit[i]==false && visit[j]==false){
                    l+=arr[i][j];
                    l+=arr[j][i];
                }
            }
        }

        int val = Math.abs(s-l);

        if(val==0){
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);
    }

}
