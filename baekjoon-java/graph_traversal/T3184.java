package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T3184 {
    static int r, c;
    static int sheep=0, wolf=0;
    static char [][] map;
    static boolean [][] check;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = { 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        check = new boolean[r][c];

        for(int i=0; i<r; i++){
            map[i] = br.readLine().toCharArray();
        }

        int a=0 ,b=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] != '#' & !check[i][j]) {
                    dfs(i,j);
                    if(sheep>wolf)a +=sheep;
                    else b += wolf;

                    sheep=0;
                    wolf=0;
                }
            }
        }
        System.out.println(a+" "+b);

    }

    static void dfs(int y, int x){
        if(map[y][x] == 'o') sheep++;
        if(map[y][x] == 'v') wolf++;
        check[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 & ny>=0 & nx<c & ny<r){
                if(map[ny][nx] != '#' & !check[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }

}
