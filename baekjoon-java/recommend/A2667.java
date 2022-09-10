package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class A2667 {
    static int n, res=0;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visit = new boolean[n][n];
        ArrayList<Integer> house = new ArrayList<>();

        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }

        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]=='1' && !visit[i][j]){
                    dfs(i,j);
                    cnt++;
                    house.add(res);
                    res=0;
                }
            }
        }

        Collections.sort(house);
        System.out.println(cnt);
        for(int h : house) System.out.println(h);

    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        res++;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny <n){
                if(map[nx][ny]=='1' && !visit[nx][ny]) dfs(nx, ny);
            }
        }
    }
}
