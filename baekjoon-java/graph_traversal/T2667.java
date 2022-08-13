package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class T2667 {
    static int n ;
    static char[][] arr;
    static int tmp=0, res=0;
    static boolean[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }


        int tmp=0;
        ArrayList<Integer> c = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == '1' && !check[i][j]){
                    dfs(i, j);
                    tmp++;
                    c.add(res);
                    res=0;
                }
            }
        }
        Collections.sort(c);
        System.out.println(tmp);
        for(int i=0; i<c.size(); i++){
            System.out.println(c.get(i));
        }


    }
    static void dfs(int y, int x){
        check[y][x] = true;
        res++;
        for(int i=0; i <4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >=0 && nx >=0 && ny <n&& nx <n){
                if(arr[ny][nx]=='1' && !check[ny][nx]) dfs(ny, nx);
            }
        }
    }
}
