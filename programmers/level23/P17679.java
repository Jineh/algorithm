import java.util.LinkedList;
import java.util.Queue;

public class P17679 {
    static boolean c[][];
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];

        for(int i=0; i<m; i++){
            arr[i] = board[i].toCharArray();
        }

        boolean flag = true;
        while(flag){
            c = new boolean[m][n];
            flag=false;
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(arr[i][j]=='#') continue;
                    if(check(i,j,arr)){
                        c[i][j]= c[i][j+1]= c[i+1][j]= c[i+1][j+1] = true;
                        flag= true;
                    }
                }
            }
            answer+= erase(m,n,arr);
        }
        return answer;
    }

    public static boolean check(int i, int j, char[][] arr){
        char tmp = arr[i][j];
        if(arr[i][j+1]==tmp && arr[i+1][j]==tmp && arr[i+1][j+1]==tmp) return true;
        return false;
    }

    public static int erase(int m, int n, char[][] arr){
        int cnt=0;

        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if(c[i][j]) arr[i][j]='0';
            }
        }

        for(int i=0; i<n; i++){
            Queue<Character> q = new LinkedList<>();
            for(int j=m-1; j>=0; j--){
                if(arr[j][i]=='0') cnt++;
                else q.add(arr[j][i]);
            }

            int tmp = m-1;
            while(!q.isEmpty()){
                arr[tmp--][i] = q.poll();
            }

            for(int j=tmp; j>=0; j--){
                arr[j][i] = '#';
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        String[] b ={"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(P17679.solution(6, 6, b));
    }
}
