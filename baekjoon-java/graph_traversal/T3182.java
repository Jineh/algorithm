package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class T3182 {
    static int n;
    static int [] person;
    static int [] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        person = new int[n+1];

        for(int i=1; i<=n; i++){
            person[i] = Integer.parseInt(br.readLine());
        }

        int max =0, res =0;
        for(int i=1; i<=n; i++){
            int s = i;
            int cnt =0;
            check = new int [n+1];

            while(true){
                if(check[s]==0){
                    cnt++;
                    check[s] =1;
                    s = person[s];
                }
                else{
                    if(cnt > max){
                        max = cnt;
                        res = i;
                    }
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
