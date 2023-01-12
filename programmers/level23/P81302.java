import java.util.LinkedList;
import java.util.Queue;

public class P81302 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int j=0; j<places.length; j++){
            char[][] arr = new char[5][5];
            for(int i=0; i<places.length; i++){
                arr[i] = places[j][i].toCharArray();
            }
            answer[j] = check(arr);
        }

        return answer;
    }

    static int check(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j<arr.length; j++) {
                if (arr[i][j] == 'P') {
                    if(!find(i, j, arr)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    static boolean find(int y, int x, char[][] arr){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {y,x});

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = tmp[0] + dy[i];
                int nx = tmp[1] + dx[i];
                if(ny==y && nx==x) continue;
                if (nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length) {
                    int d = Math.abs(ny-y) + Math.abs(nx-x);
                    if(arr[ny][nx]=='P' && d<=2) return false;
                    else if(arr[ny][nx]=='O'&& d<2) queue.offer(new int[]{ny,nx});
                }
            }
        }

        return true;
    }


    public static void main(String args[]) throws Exception{
        String[][] arr = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(P81302.solution(arr));

    }
}
