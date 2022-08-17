package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T2636 {
    static int m, n;
    static int[][] map;
    static boolean[][] check;
    static int cnt=0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) cnt++;
            }
        }

        int cheesecnt=0;
        int time =0;
        while(cnt != 0){
            cheesecnt = cnt;
            time++;
            check = new boolean[m][n];
            bfs();
        }
        System.out.println(time);
        System.out.println(cheesecnt);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        q.offer(0);
        check[0][0] = true;

        while(!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m ) {
                    if(!check[ny][nx]) {
                        check[ny][nx] = true;
                        if (map[ny][nx] == 0) {
                            q.offer(ny);
                            q.offer(nx);
                        } else {
                            cnt--;
                            map[ny][nx] = 0;
                        }
                    }
                }
            }
        }
    }

}
