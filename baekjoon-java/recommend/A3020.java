package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] bot = new int[h+2];
        int[] top = new int[h+2];

        for(int i=0; i<n/2; i++){
            bot[Integer.parseInt(br.readLine())]++;
            top[h-Integer.parseInt(br.readLine())+1]++;
        }

        for(int i=1; i<=h; i++){
            bot[i]+=bot[i-1];
        }

        for(int i=h; i>=1; i--){
            top[i]+=top[i+1];
        }

        int min =n;
        int cnt=0;

        for(int i=1; i<=h; i++){
            int obs = (bot[h] - bot[i-1]) + (top[1] - top[i+1]);
                    // 내 높이 보다 작은 것은 지나치니 그 전의 누적값은 뺌
            if(obs <min){
                min = obs;
                cnt =1;
            }else if(obs ==min) cnt++;
        }

        System.out.println(min+" "+ cnt);
    }
}
