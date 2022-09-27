package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1080 {
    static int n;
    static int m;
    static int [][] a;
    static int [][] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        b = new int[n][m];

        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(tmp[j]);
            }
        }


        int cnt =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j] && i + 2 < n && j + 2 < m) {
                    reverse(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);



    }

    static void reverse(int i, int j){
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                a[r][c] = a[r][c] == 0 ? 1 : 0;
            }
        }
    }
}
