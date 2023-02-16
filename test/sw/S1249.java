import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1249 {
    static int min;
    static int[][] map, ans;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            min=Integer.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            ans= new int[n][n];
            check = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
            ans[0][0]=0;
            find(0,0);
            sb.append('#').append(++cnt).append(" ").append(min).append('\n');
        }
        System.out.println(sb);
    }

    static void find(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a,b});
        check[a][b] = true;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x=tmp[0];
            int y=tmp[1];

            if (x == map.length - 1 && y == map.length - 1) {
                min = Math.min(min, ans[x][y]);
            }
            if (ans[x][y] >= min) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;
                if (!check[nx][ny] || ans[nx][ny] > ans[x][y] + map[nx][ny]) {
                    check[nx][ny] = true;
                    ans[nx][ny] = ans[x][y] + map[nx][ny];
                    queue.offer(new int[]{nx, ny});
                }
            }

        }
    }
}
