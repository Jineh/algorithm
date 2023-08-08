package graph_traversal;

import java.io.*;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B3055{
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        for(int i=0; i<r; i++){
            map[i] = br.readLine().toCharArray();
        }

        int res = bfs(map);
        String result = (res==0) ? "KAKTUS" : String.valueOf(res);

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();

    }


    public static int bfs(char[][] map){
        Queue<int[]> water = new LinkedList<>();
        Queue<int[]> start = new LinkedList<>();
        int desX=0, desY=0;

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j]=='*') water.offer(new int[]{i, j});
                else if(map[i][j]=='S') start.offer(new int[] {i, j});
                else if(map[i][j]=='D') {
                    desX = i;
                    desY = j;
                }
            }

        }

        int time=0;
        while(!water.isEmpty() || !start.isEmpty()) {
            int size = water.size();
            time++;

            while(size-->0) {
                int[] tmp = water.poll();
                for(int i=0; i<4; i++) {
                    int x = tmp[0] + dx[i];
                    int y = tmp[1] + dy[i];

                    if(x<0 || y <0 || x>=map.length || y >= map[0].length ) continue;
                    if(map[x][y]=='.' || map[x][y]=='S') {
                        map[x][y] = '*';
                        water.offer(new int[] {x, y});
                    }
                }

            }

            size = start.size();
            while(size-->0) {
                int[] tmp = start.poll();

                for(int i=0; i<4; i++) {
                    int x = tmp[0] + dx[i];
                    int y = tmp[1] + dy[i];

                    if(x<0 || y <0 || x>=map.length || y >= map[0].length ) continue;
                    if(map[x][y]=='.') {
                        map[x][y] = 'S';    // s로 표시하지 않으면 계속 값을 넣는다.
                        start.offer(new int[] {x, y});
                    }
                    else if(map[x][y]=='D') return time;
                }
            }
        }
        return 0;
    }
}