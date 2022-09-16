package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A2638 {
    static int n, m;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<int[]> cheese = new ArrayList<>();
    static int cheeseCnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    cheese.add(new int[]{i,j});
                    cheeseCnt++;
                }
            }
        }

        int time=0;

        while(cheeseCnt !=0){
            time++;
            check = new boolean[n][m];
            dfs(0,0);
            melting();
        }
        System.out.println(time);
    }

    static void melting(){
        for(int i = 0; i < cheese.size(); i++) {
            int x = cheese.get(i)[0];
            int y = cheese.get(i)[1];
            int cnt = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (map[nx][ny] == 2) cnt++;
            }

                if(cnt>=2){
                    map[x][y]=0;
                    cheeseCnt--;
                    cheese.remove(i);
                    i--;
                }
            }
        }


    static void dfs(int x, int y){
        check[x][y] = true;
        map[x][y] = 2;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (check[nx][ny] || map[nx][ny] == 1) continue;

            dfs(nx, ny);
        }
    }
}
