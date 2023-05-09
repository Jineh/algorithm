import java.util.*;
public class P86971 {
    public boolean[][] map;
    public int solution(int n, int[][] wires) {
        map = new boolean[n+1][n+1];

        for(int[] w: wires){
            int a= w[0], b=w[1];
            map[a][b] = map[b][a] = true;
        }

        int min=n+1;
        for(int[] w: wires){
            int a= w[0], b=w[1];
            map[a][b] = map[b][a] = false;

            min = Math.min(bfs(n, a), min);

            map[a][b] = map[b][a] = true;
        }

        return min;
    }

    public int bfs(int n, int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        boolean[] check = new boolean[n+1];
        check[a] = true;
        int cnt=1;

        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int i=1; i<=n; i++){
                if(map[x][i] && !check[i]){
                    queue.offer(i);
                    cnt++;
                    check[i] = true;
                }
            }
        }
        return Math.abs((n-cnt)-cnt);

    }
}