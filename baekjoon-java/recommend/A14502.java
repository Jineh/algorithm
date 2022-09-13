package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A14502 {
    static int n, m, safe=Integer.MIN_VALUE;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(safe);
    }

    static void dfs(int wallCnt){
        if(wallCnt == 3){
            bfs();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(wallCnt+1);
                    map[i][j]=0;
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] copy = new int[n][m];

        for(int i=0; i<n; i++) copy[i] = map[i].clone();

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(copy[nx][ny] ==0){
                        q.offer(new int[]{nx,ny});
                        copy[nx][ny]=2;
                    }
                }
            }
        }
        findSafe(copy);

    }
    static void findSafe(int[][] copy){
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copy[i][j] ==0) cnt++;
            }
        }

        if(safe < cnt) safe = cnt;
    }
}
