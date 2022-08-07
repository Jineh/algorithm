package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1388 {
    static int n;
    static int m;
    static char [][] map;
    static int [][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        check = new int[n][m];

        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }

        int cnt =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(check[i][j]==0){
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int a, int b){
        if(map[a][b] == '-' && b+1< m){
            for(int i=b+1; i<m; i++)
            {
                if(map[a][i] == '|') return;
                else check[a][i] =1;
            }
            return;
        }
        else if(map[a][b] == '|' && a+1< n){
            for(int i=a+1; i<n; i++)
            {
                if(map[i][b] == '-') return;
                else check[i][b] =1;
            }
            return;
        }
    }


}
