package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T16918 {
    static int r, c, n;
    static char[][] map;
    static int[][] btime;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        btime = new int[r][c];


        for (int i = 0; i < r; i++) {
             String tmp = br.readLine();
             for(int j=0; j<c; j++){
                 map[i][j] = tmp.charAt(j);
                 if(map[i][j]=='O'){
                     btime[i][j] =3;
                 }
             }
        }

        int time=0;

        while(time++ <n){
            if (time % 2 == 0) {
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++){
                        if(map[i][j] == '.'){
                            map[i][j] = 'O';
                            btime[i][j] = time+3;
                        }
                    }
                }
            } else if (time % 2 == 1) {
                for(int i=0; i<r; i++){
                    for(int j=0; j<c; j++) {
                        if (btime[i][j] == time) {
                            map[i][j] = '.';
                            change(i, j, time);
                        }
                    }
                }
            }
        }

        for(int i=0; i<r; i++){
            System.out.println(map[i]);
        }

    }

    static void change(int y, int x, int time){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx<c && ny<r) {
                if(map[ny][nx] == 'O' && btime[ny][nx] !=time) {
                    map[ny][nx] = '.';
                    btime[ny][nx] = 0;
                }
            }
        }
    }
}
