package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char [][] map = new char[n][n];
        int [] result = new int[n];
        int [][] mark = new int[n][n];

        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 'Y') {
                    if (mark[i][j] == 0) {
                        result[i]++;
                        mark[i][j] = 1;
                    }
                    for (int k = 0; k < n; k++) {
                        if (map[j][k] == 'Y' && mark[i][k] == 0 && i != k) {
                            result[i]++;
                            mark[i][k] =1;
                        }
                    }
                }
            }
        }

        Arrays.sort(result);
        System.out.println(result[n-1]);


    }
}
