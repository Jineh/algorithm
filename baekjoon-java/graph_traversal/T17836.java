package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class T17836 {
    static int m, n,t;
    static int[][] map;
    static boolean[][] check;
    static int res=0;
    static int gx, gy;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static Queue<int []> q = new LinkedList<>();
    static ArrayList<Integer> time = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    gy = i;
                    gx = j;
                }
            }
        }

        q.offer(new int []{0, 0, 0});
        check[0][0] = true;

        while(!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                int[] tmp = q.poll();
                int y = tmp[0];
                int x = tmp[1];

                if(y==n-1 && x==m-1){
                    time.add(tmp[2]);
                }
                if(y==gy && x==gx){
                    time.add((n-1-y)+(m-1-x) + tmp[2]);
                }

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        if (!check[ny][nx] && (map[ny][nx] == 0 || map[ny][nx]==2)) {
                            q.offer(new int[] {ny, nx, tmp[2]+1});
                            check[ny][nx] = true;
                        }
                    }
                }
            }
        }
        if(time.isEmpty()) System.out.println("Fail");
        else{
            Collections.sort(time);
            if(time.get(0)<=t) System.out.println(time.get(0));
            else System.out.println("Fail");
        }


    }
}
