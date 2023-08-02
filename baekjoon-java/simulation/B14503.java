package simulation;

import java.io.*;
import java.util.StringTokenizer;

public class B14503 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] dx2 = {-1, 0, 1, 0};
    static int[] dy2 = {0, 1, 0, -1};
    static int n, m, startX, startY, startD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        startD = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res=0;
        while(true){
            if(map[startX][startY]==0) {
                map[startX][startY]=2;
                res++;
            }
            boolean check = find(startX, startY, map);
            if(check){
                cleaning(startX, startY, startD, map);
            }
            else{
                if(!move(startX, startY, startD, map)) break;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }


    public static boolean find(int x, int y, int[][] map){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            if(map[nx][ny]==0) return true;
        }
        return false;
    }

    public static boolean move(int x, int y, int d, int[][] map){
        int nx = x + dx[d];
        int ny = y + dy[d];
        if(nx<0 || nx>=n || ny<0 || ny>=m)
            return false;
        if(map[nx][ny]==1) return false;
        startX = nx;
        startY = ny;
        return true;
    }

    public static void cleaning(int x, int y, int d, int[][] map){
        for(int i=0; i<4; i++){
            d = (d==0) ? 3 : d-1;
            int nx = x + dx2[d];
            int ny = y + dy2[d];
            if(nx<0 || nx>=n || ny<0 || ny>=m)
                continue;
            if(map[nx][ny]==0){
                startX = nx;
                startY = ny;
                startD = d;
                return;
            }
        }
    }
}
