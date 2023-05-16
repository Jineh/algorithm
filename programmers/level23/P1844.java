import java.util.*;
public class P1844 {
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int answer =-1;
        int n = maps.length-1;
        int m = maps[0].length-1;
        boolean[][] visit = new boolean[n+1][m+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visit[0][0] = true;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y = tmp[0];
            int x = tmp[1];

            if(y==n && x==m) return maps[y][x];

            for(int i=0; i<4; i++){
                int yy = y + dy[i];
                int xx = x + dx[i];
                if(yy<0|| xx<0|| yy>n || xx>m) continue;
                if(maps[yy][xx]==0 || visit[yy][xx])continue;
                maps[yy][xx]=maps[y][x]+1;
                queue.offer(new int[]{yy, xx});
                visit[yy][xx] = true;
            }
        }
        return answer;
    }
}