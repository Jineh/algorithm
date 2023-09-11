package graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B6593 {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0 , 0, 0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int l, r, c, sl=0, sr=0, sc=0;
        char [][][] map;

        while(true){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l==0 && r==0 && c==0) break;

            map = new char[l][r][c];

            for(int i=0; i<l; i++){
                for(int j=0; j<r; j++){
                    map[i][j] = br.readLine().toCharArray();
                    for(int k=0; k<c; k++){
                        if(map[i][j][k]=='S') {
                            sl = i;
                            sr = j;
                            sc = k;
                        }
                    }
                }
                br.readLine();
            }
            int time = find(map, sl, sr, sc, l, r, c);
            if(time==-1) bw.write("Trapped!\n");
            else bw.write("Escaped in "+ time +" minute(s).\n");
        }
        bw.close();
        br.close();
    }



    public static int find(char[][][] map, int sl, int sr, int sc, int l, int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sl, sr, sc});
        boolean [][][] check = new boolean [l][r][c];
        int time=-1;

        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            while(size-->0){
                int[] tmp = queue.poll();
                if(map[tmp[0]][tmp[1]][tmp[2]]=='E') return time;

                for(int i=0; i<6; i++){
                    int nz = tmp[0] + dz[i];
                    int nx = tmp[1] + dx[i];
                    int ny = tmp[2] + dy[i];

                    if(nz<0 || nx<0 || ny<0 ||
                            nz>=l || nx>=r ||  ny>=c) continue;
                    if(map[nz][nx][ny]== '#' || check[nz][nx][ny]) continue;

                    check[nz][nx][ny] = true;
                    queue.offer(new int[]{nz, nx, ny});
                }
            }
        }
        return -1;
    }
}
