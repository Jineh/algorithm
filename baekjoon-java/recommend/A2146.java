package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2146 {
    static int n;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new boolean[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        marking();


        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]>0){
                    check = new boolean[n][n];
                    int res =solve(i, j);

                    if(res== -1) continue;
                    min = Math.min(res, min);
                }
            }
        }
        System.out.println(min);

    }

    static void marking(){
        Queue<Integer> q = new LinkedList<>();
        int idx =2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1 && !check[i][j]){
                    q.offer(i);
                    q.offer(j);
                    check[i][j]=true;
                    map[i][j]=idx;

                    while(!q.isEmpty()){
                        int x = q.poll();
                        int y = q.poll();

                        for(int k=0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx>=0 && ny>=0 && nx<n && ny<n ){
                                if(map[nx][ny]==1 && !check[nx][ny]) {
                                    map[nx][ny] = idx;
                                    check[nx][ny] = true;
                                    q.offer(nx);
                                    q.offer(ny);
                                }
                            }
                        }
                    }

                    idx++;
                }
            }
        }
    }


    static int solve(int a, int b) {
        int strN = map[a][b];
        int br = -1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        q.offer(b);
        check[a][b] = true;

        while (!q.isEmpty()) {
            int len = q.size() / 2;
            br++;
            while (len-- > 0) {
                int x = q.poll();
                int y = q.poll();


                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (!check[nx][ny] && map[nx][ny] != strN) {
                            if (map[nx][ny] != 0) {
                                return br;
                            }
                            check[nx][ny] = true;
                            q.offer(nx);
                            q.offer(ny);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
