package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A10819 {
    static int n, res=0;
    static int[] arr, tmp;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        v = new boolean[n];
        tmp = new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);

        System.out.println(res);
    }

    static void dfs(int cnt){
        if(cnt==n){
            int sum=0;
            for(int i=0; i<n-1; i++){
                sum+=Math.abs(tmp[i]-tmp[i+1]);
            }
            res = Math.max(res, sum);
            return;
        }

        for(int i=0; i<n; i++){
            if(v[i]) continue;
            v[i]=true;
            tmp[cnt] = arr[i];
            dfs(cnt+1);
            v[i]=false;
        }
    }
}
