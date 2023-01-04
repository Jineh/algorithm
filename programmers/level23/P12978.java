public class P12978 {
    private static int INF = 500001;
    public static int solution(int N, int[][] road, int K) {
        int answer=0;
        int[][] arr = new int[N+1][N+1];

        for (int i = 1; i <arr.length; i++) {
            for (int j = 1; j <arr[1].length; j++) {
                if (i == j){
                    continue;
                }
                arr[i][j] = INF;
            }
        }

        for(int[] data:road){
            if(arr[data[0]][data[1]]<data[2]){
                continue;
            }
            arr[data[0]][data[1]]=data[2];
            arr[data[1]][data[0]]=data[2];
        }

        for(int i=2; i<arr.length; i++){
            for(int j=1; j<arr.length; j++){
                for(int k=1; k<arr.length; k++){
                    if(arr[j][k] > arr[j][i] + arr[i][k]){
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        for(int i=1; i<arr[1].length; i++){
            if(arr[1][i] <=K) answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        int[][] a = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
                //{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        System.out.println(P12978.solution(6, a, 4));
    }
}
