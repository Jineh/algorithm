package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T1012 {
    static int n,m,k;
    static int [][] arr;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = { 0, 0, -1, 1};
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int x,y;
        StringBuffer sb = new StringBuffer();


        while(t-->0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int [m][n];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr[x][y] =1;
                q.offer(x);
                q.offer(y);
            }
            int cnt=0;
            while(!q.isEmpty()){
                int x1 = q.poll();
                int y1 = q.poll();
                if(arr[x1][y1] == 1){
                    dfs(x1,y1);
                    cnt++;
                }
            }
            sb.append(cnt);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y){
        if(arr[x][y]==1){
            arr[x][y] = -1;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny <n){
                    if(arr[nx][ny] ==1) dfs(nx, ny);
                }
            }
        }
    }


}
