import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S12318 {

    private final static UserSolution usersolution = new UserSolution();

    private static BufferedReader br;

    private static int cmd_bfs() throws Exception {

        int score = 100;
        int N, M, x1, y1, x2, y2, dist, ans;
        int[][] map = new int[10][10];
        String str;
        StringTokenizer st;

        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = Integer.parseInt(str);

        for(int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        usersolution.bfs_init(N, map);

        str = br.readLine();
        M = Integer.parseInt(str);

        for(int i = 1; i <= M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            ans = Integer.parseInt(st.nextToken());

            dist = usersolution.bfs(x1, y1, x2, y2);
            if(dist != ans) {
                score = 0;
            }
        }
        return score;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("#total score : " + cmd_bfs());
    }


    static class UserSolution {
        int [][] map;
        boolean [][] check;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        void bfs_init(int map_size, int map[][]) {
            this.map = new int[map_size][map_size];
            for(int i=0; i<map_size; i++){
                for(int j=0; j<map_size; j++){
                    this.map[i][j]= map[i][j];
                }
            }
        }

        int bfs(int x1, int y1, int x2, int y2) {
            int head=0, size=0, front=0;
            int [][] queue = new int[map.length*map.length][2];
            check = new boolean[map.length][map.length];
            queue[head][0] = x1;
            queue[head++][1] = y1;
            check[y1-1][x1-1] = true;
            size++;

            int res =0;
            while(size!=0){
                int cnt=size;
                size=0;
                while(cnt-->0) {
                    int xx = queue[front][0];
                    int yy = queue[front++][1];
                    if(xx==x2 && yy==y2) return res;
                    for (int i = 0; i < 4; i++) {
                        int nx = xx + dx[i];
                        int ny = yy + dy[i];
                        if (nx <= 0 || nx > map.length || ny <= 0 || ny > map.length) continue;
                        if (check[ny-1][nx-1] || map[ny-1][nx-1]==1) continue;
                        check[ny-1][nx-1]=true;
                        queue[head][0]=nx;
                        queue[head++][1]=ny;
                        size++;
                    }
                }
                res++;
            }
            return -1;
        }

    }
}
