package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T16234 {
    static int n, l, r;
    static int[][] arr;
    static int[][] my;
    static boolean[][] check;
    static int[] avg;
    static int sum=0, p=0, res=0, pre=0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int [n][n];
        my = new int[n][n]; //국경선 연결된 곳 표시
        avg = new int[n*n]; //연결된 곳 총 합에서 인구수만큼 평균 저장


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            int cnt = 0, mySum=0; //연결된 도시 수, 연결된 도시 평균들의 총합(종료 확인 위해서)
            check = new boolean[n][n]; //방문한 곳 표시

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!check[i][j]) {
                        my[i][j] = cnt; // dfs로 방문해서 국경선이 열린 곳들은 같은 cnt값으로 저장
                        dfs(i, j);
                        avg[cnt] = sum/p; //연결된 국가의 인구수 합을 국가 수 만큼 나눔
                        mySum+=avg[cnt]; // 연결된 국가의 평균 누적
                        cnt++; //다음 국가로 이동시 값 증가(국경선이 안 열렸으니)
                        p=0;//초기화
                        sum=0;
                    }
                }
            }
            if(pre==mySum || cnt==(n*n)){ //모든 국가의 국경선이 열리지 않으면 cnt값은 n*n만큼 증가 됨
                break; //종료 조건으로 이전에 저장한 값이랑 연결된 국가 평균 값이 같으면 종료
            }
            res++; //하루 지남
            pre=mySum; //이전 값 저장

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = avg[my[i][j]]; //my 배열에 cnt값이 있고 avg에 cnt index의 평균 값이 저장 됨
                }
            }


        }

        System.out.println(res);

    }

    static void dfs(int y, int x){
        p++;
        sum+=arr[y][x];
        check[y][x] = true;
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx >=0 && ny >=0 && nx <n && ny <n){
                if(!check[ny][nx]){
                    int min = Math.abs(arr[y][x] - arr[ny][nx]);
                    if(min >= l && min<=r){
                        my[ny][nx] = my[y][x];
                        dfs(ny, nx);
                    }
                }
            }
        }
    }
}
