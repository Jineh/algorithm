package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T10971 {
    static int n;
    static int[][] arr;
    static int[] check;
    static int res=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        check = new int[n];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
            }


        check[0] = 1;
        dfs(0, 0,0, 0);
        System.out.println(res);

    }

    static void dfs(int start, int node, int sum, int cnt){

        if (cnt==n && node == start){
            res = Math.min(res, sum);
            return;
        }
        for(int i=0; i<n; i++){
            if(arr[node][i] >0){
                if(i == start && cnt == n-1){
                    dfs(start, i, sum+ arr[node][i], cnt+1);
                }
                else if(check[i]==0){
                    check[i] = 1;
                    dfs(start, i, sum+arr[node][i], cnt+1);
                    check[i] =0;
                }
            }
        }

    }
}
