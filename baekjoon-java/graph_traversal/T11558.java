package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T11558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- >0){
            int n = Integer.parseInt(br.readLine());
            int[] person = new int[n+1];
            int[] check = new int[n+1];

            for(int j=1; j<=n; j++){
                person[j] = Integer.parseInt(br.readLine());
            }

            int start = 1;
            int cnt =0;
            while (true) {
                if(person[start] == n) {
                    cnt++;
                    break;
                }
                if(check[person[start]] == 1){ //가려는 곳이 이미 1이면

                    break;
                }
                else {
                    start = person[start];
                    check[start] = 1;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

}
