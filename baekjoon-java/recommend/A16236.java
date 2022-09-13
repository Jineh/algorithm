package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A16236 {
    static int  max_val=401, max_int =21;
    static int n, sx, sy, min_dist, min_x, min_y, result, eat_cnt=0, s_size=2;
    static int[][] map, check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        check = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9) {
                    sx=i;
                    sy=j;
                    map[i][j] =0;
                }
            }
        }

        while(true){
            init();

            bfs(sx, sy);
            if(min_x!=max_int && min_y !=max_int){
                result +=check[min_x][min_y];

                eat_cnt++;

                if(eat_cnt == s_size){ //자기 크기만큼 물고기 먹었는지 확인
                    s_size++;
                    eat_cnt=0;
                }

                map[min_x][min_y]=0;

                sx = min_x; //마지막으로 먹은 위치부터 시작
                sy =min_y;
            }

            else{ //고기를 먹을 수 없다면 좌표가 바뀌지 않음
                break;
            }
        }
        System.out.println(result);
    }

    static void init(){
        min_dist = max_val;
        min_x = max_int;
        min_y = max_int;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                check[i][j] =-1;
            }
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        check[x][y] =0;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if(check[nx][ny] != -1 || map[nx][ny] > s_size) continue;

                check[nx][ny] = check[x][y]+1;

                if(map[nx][ny] !=0 && map[nx][ny] < s_size){

                    if(min_dist > check[nx][ny]){
                        min_x=nx;
                        min_y=ny;
                        min_dist = check[nx][ny];
                    }
                    else if(min_dist==check[nx][ny]){// 위쪽 물고기 확인
                        if(min_x == nx){
                            if(min_y > ny){ //왼쪽부터 확인
                                min_x = nx;
                                min_y = ny;
                            }
                        }else if(min_x > nx){
                            min_x = nx;
                            min_y = ny;
                        }
                    }
                }
                q.offer(new int[]{nx,ny});
            }
        }

    }
}
