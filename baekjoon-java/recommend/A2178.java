package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A2178 {
    static int n, m;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];

        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        visit[x][y] = true;
        q.offer(x);
        q.offer(y);
        int res = 0;
        while(!q.isEmpty()) {
            int len = q.size() / 2;
            res++;
            while (len-- > 0) {
                int a = q.poll();
                int b = q.poll();
                if (a == n - 1 && b == m - 1) return res;
                for (int i = 0; i < 4; i++) {
                    int nx = a + dx[i];
                    int ny = b + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (map[nx][ny] == '1' && !visit[nx][ny]) {
                            q.offer(nx);
                            q.offer(ny);
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return res;
    }
}
