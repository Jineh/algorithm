package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T14248{
    static int n, s;
    static int res=0;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        check = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());
        dfs(s, arr[s]);
        res++;
        System.out.println(res);
    }

    static void dfs(int start, int jump){
        int left = start - jump;
        int right = start + jump;


        if(left >= 1 && !check[left]){
            check[left] = true;
            res++;
            dfs(left, arr[left]);
        }
        if(right <= n && !check[right]){
            check[right] = true;
            res++;
            dfs(right, arr[right]);
        }

    }
}
