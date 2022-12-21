public class P68645 {
    public static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
        int tmp=1, row=-1, col=0;

        for(int i=n; i>0; i-=3){
            for(int j=0; j<i; j++) arr[++row][col] = tmp++;
            for(int j=0; j<i-1; j++) arr[row][++col] = tmp++;
            for(int j=0; j<i-2; j++) arr[--row][--col] = tmp++;
        }

        int idx =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==0) break;
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(P68645.solution(4));
    }
}
