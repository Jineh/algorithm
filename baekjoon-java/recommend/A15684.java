package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A15684 {
    static int n, m, h, ans;
    static int[][] map;
    static boolean finish = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h+1][n+1];

        for(int y=0; y<m; y++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] =1;
            map[a][b+1] =2;
        }

        for(int i=0; i<=3; i++){
            ans = i;
            dfs( 0);
            if(finish) break;
        }

        System.out.println(finish? ans: -1);

    }

    static void dfs( int add){
        if(add>3) return;
        if(ans == add){
            if(check()) finish=true;
            return;
        }

        for(int i=1; i<=h; i++){
            for(int j=1; j<n; j++){
                if(map[i][j] == 0&& map[i][j+1] ==0){
                    map[i][j] =1;
                    map[i][j+1] =2;

                    dfs(add+1);

                    map[i][j]=0;
                    map[i][j+1]=0;
                }
            }
        }
    }

    static boolean check(){
        for(int i=1; i<=n; i++){
            int nx =i;
            int ny =1;

            while(ny<=h){
                if(map[ny][nx] == 1) nx++;
                else if(map[ny][nx]==2) nx--;
                ny++;
            }

            if(nx != i) return false;
        }

        return true;
    }
}
