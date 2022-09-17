package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1987 {
    static int r, c, res=Integer.MIN_VALUE;
    static char[][] map;
    static boolean[][] check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[] alpha= new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        check = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();;
        }

        solve(0, 0, 0);
        System.out.println(res);
    }

    static void solve(int x, int y, int len){
        if(alpha[map[x][y]-65]){
            res = Math.max(len, res);
            return;
        }

        alpha[map[x][y] - 65] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            solve(nx, ny, len + 1);
        }
        alpha[map[x][y] - 65] = false;

    }
}
