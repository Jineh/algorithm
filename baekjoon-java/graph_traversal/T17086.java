package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T17086 {
    static int n, m;
    static int res=0;
    static int[][] arr;
    static boolean[] check;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, -0, 1, -1, -1, 1, 1, -1};
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    q.offer(i);
                    q.offer(j);
                }
            }
        }

        while(!q.isEmpty()){
            int y = q.poll();
            int x = q.poll();
            for(int i=0; i<8; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny>=0 && nx >=0 && ny<n && nx <m){
                    if(arr[ny][nx] == 0){
                        q.offer(ny);
                        q.offer(nx);
                        arr[ny][nx] = arr[y][x] +1;
                        res = Math.max(res, arr[y][x] +1);
                    }
                }
            }
        }

        System.out.println(res-1);

    }
}
