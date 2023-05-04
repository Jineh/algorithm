import java.util.LinkedList;
import java.util.Queue;

public class P87694 {
    public int[][] map = new int[101][101];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        for(int[] tmp : rectangle){
            int y1= tmp[1]*2, y2 = tmp[3]*2;
            int x1 = tmp[0]*2, x2 = tmp[2]*2;
            for(int j=y1; j<=y2; j++){
                for(int i=x1; i<=x2; i++){
                    if(map[j][i]==2) continue;
                    else if(i==x1||i==x2||j==y1||j==y2) map[j][i] = 1;
                    else map[j][i] = 2;
                }
            }
        }

        return bfs(characterY*2, characterX*2, itemY*2, itemX*2);
    }


    public int bfs(int s1, int s2, int i1, int i2){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s1, s2});
        boolean[][] check = new boolean[101][101];


        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            check[tmp[0]][tmp[1]]=true;
            if(tmp[0]==i1 && tmp[1]==i2) break;
            for(int i=0; i<4; i++){
                int y = dy[i] + tmp[0];
                int x = dx[i] + tmp[1];
                if(y<0||x<0||y>100||x>100) continue;
                if(map[y][x]==1 && !check[y][x]) {
                    queue.offer(new int[]{y,x});
                    map[y][x]=map[tmp[0]][tmp[1]]+1;
                }

            }
        }
        return map[i1][i2]/2;
    }
}
