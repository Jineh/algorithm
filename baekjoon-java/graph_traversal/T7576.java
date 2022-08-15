package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T7576 {
    static int m, n;
    static int[][] map;
    static boolean[][] check;
    static int res=0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int [n][m];
        int cnt=0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) cnt++;
                else if(map[i][j] == 1) {
                    q.offer(i);
                    q.offer(j);
                }
            }
        }
        if(q.isEmpty()){
            System.out.println(-1);
            return;
        }
        else if(cnt==n*m){
            System.out.println(0);
            return;
        }
        else{
            while(!q.isEmpty()){
                int t = q.size()/2;
                while(t-- >0){
                    int y = q.poll();
                    int x = q.poll();

                    for(int i=0; i<4; i++){
                        int ny = y+dy[i];
                        int nx = x+dx[i];
                        if(nx>=0 && ny >=0 && nx<m && ny <n){
                            if(map[ny][nx]==0){
                                q.offer(ny);
                                q.offer(nx);
                                map[ny][nx]=1;
                                cnt--;
                            }
                        }
                    }
                }
                res++;
            }
        }
        if(cnt==0){
            System.out.println(--res);
        }
        else{
            System.out.println(-1);
        }

    }

}
