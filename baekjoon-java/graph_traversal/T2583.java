package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class T2583 {
    static int n, m, k;
    static int[][] arr;
    static boolean[][] check;
    static int tmp = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        check = new boolean[m][n];

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 =Integer.parseInt(st.nextToken());
            int y1 =Integer.parseInt(st.nextToken());
            int x2 =Integer.parseInt(st.nextToken());
            int y2 =Integer.parseInt(st.nextToken());

            for(int j =y1; j<y2; j++){
                for(int i=x1; i<x2; i++){
                    arr[j][i] = 1;
                }
            }
        }

        int cnt=0;
        ArrayList<Integer> c = new ArrayList<Integer>();
        for(int j =0; j<m; j++){
            for(int i=0; i<n; i++){
                if(arr[j][i] ==0 && !check[j][i]) {
                    dfs(j, i);
                    cnt++;
                    c.add(tmp);
                    tmp=0;
                }
            }
        }

        Collections.sort(c);
        System.out.println(cnt);
        for(int i=0; i<c.size(); i++){
            System.out.print(c.get(i)+" ");
        }

    }

    static void dfs(int y, int x){
        check[y][x] = true;
        tmp++;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && ny >=0 && nx <n&& ny<m){
                if(!check[ny][nx] && arr[ny][nx] ==0) dfs(ny,nx);
            }
        }

    }
}
