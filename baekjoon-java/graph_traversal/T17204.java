package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T17204 {
    static int n;
    static int k;
    static int [] person;
    static int [] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        person = new int[n];
        check = new int[n];

        for(int i=0; i<n; i++){
            person[i] = Integer.parseInt(br.readLine());
        }

        int cnt=1, start =0;
        while(true){
            if(check[start]==0){
                if(person[start] == k) break;
                else {
                    cnt++;
                    check[start] =1;
                    start = person[start];
                }
            }
            else{
                cnt=-1;
                break;
            }
        }

        System.out.println(cnt);
    }
}
