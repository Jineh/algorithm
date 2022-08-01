package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1455 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int res =0;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(arr[i][j]==1){
                    reverse(i, j);
                    res++;
                }
            }
        }

        System.out.println(res);



    }

    static void reverse(int a, int b){
        for(int i=a; i>=0; i--){
            for(int j=b; j>=0; j--){
               arr[i][j]= (arr[i][j]==1) ? 0 : 1;
            }
        }

    }
}
