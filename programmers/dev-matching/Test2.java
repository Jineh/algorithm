
public class Test2 {
    static class Solution {
        static char[][] map;
        static boolean[][] check;
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, -1, 1};
        static int n, m;
        static int[] area;
        static int[] total = new int[26];

        public static int solution(String[] maps) {
            int answer = 0;

            n = maps.length;
            m = maps[0].length();
            map = new char[n][m];
            check = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                map[i] = maps[i].toCharArray();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != '.' && !check[i][j]) {
                        area = new int[26];
                        dfs(i, j);
                        count();
                    }
                }
            }


            for(int i=0; i<total.length; i++){
                answer = Math.max(total[i], answer);
            }
            return answer;
        }

        static void dfs(int x, int y) {
            check[x][y] = true;
            area[map[x][y] - 'A']++;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!check[nx][ny] && map[nx][ny] != '.') {
                        dfs(nx, ny);
                    }
                }
            }

        }

        static void count() {
            int res=area[0];
            int cnt=1;
            int last=0;
            int sum =area[0];
            for(int i=1; i<area.length; i++){
                sum+=area[i];
                if(res < area[i]) {
                    cnt=1;
                    res = area[i];
                    last =i;
                }
                else if( res == area[i]) {
                    cnt++;
                    last = i;
                }
            }

            if(cnt==0) total[last]+=sum;
            else if(cnt!=0){
                for(int i=0; i<area.length; i++){
                    if(res == area[i]) total[i]+=res;
                }
                int r = sum - res*cnt;
                System.out.println(r);
                total[last]+=r;

            }

        }
    }

    public static void main(String[] args) {

        //String[] map = {"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A",
        //"....EE..", ".M.XXEXQ", "KL.TBBBQ"};

        String[] map = {"XY..", "YX..", "..YX", ".AXY"};

        System.out.println(Solution.solution(map));
    }
}
