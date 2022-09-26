
public class P77485 {
    static class Solution {
        static int[][] map;
        public static int[] solution(int rows, int columns, int[][] queries) {
            map = new int[rows+1][columns+1];
            int k=1;
            int size = queries.length;
            int[] answer = new int[size];
            int x1, x2, y1, y2;

            for(int i=1; i<=rows; i++){
                for(int j=1; j<=columns; j++){
                    map[i][j]=k++;
                }
            }

            for(int i=0; i<size; i++){
                x1 = queries[i][0];
                y1 = queries[i][1];
                x2 = queries[i][2];
                y2 = queries[i][3];
                answer[i] = rotation(x1, y1, x2, y2);
            }


            return answer;
        }

        static int rotation(int x1, int y1, int x2, int y2){
            int tmp, next, res;
            tmp = map[x1][y1]; //시작
            res=tmp;
            //우
            for(int i=y1; i<y2; i++) {
                next = map[x1][i+1];
                map[x1][i+1]=tmp;
                tmp=next;
                res = Math.min(tmp, res);
            }

            //하
            for(int i=x1; i<x2; i++) {
                next = map[i+1][y2];
                map[i+1][y2]=tmp;
                tmp=next;
                res = Math.min(tmp, res);
            }

            //좌
            for(int i=y2; i>y1; i--) {
                next = map[x2][i-1];
                map[x2][i-1]=tmp;
                tmp=next;
                res = Math.min(tmp, res);
            }

            //상
            for(int i=x2; i>x1; i--) {
                next = map[i-1][y1];
                map[i-1][y1]=tmp;
                tmp=next;
                res = Math.min(tmp, res);
            }

            System.out.println(res);
            return res;
        }
    }




    public static void main(String[] args) {

        int[][] l = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        Solution.solution(6, 6, l);
    }
}
