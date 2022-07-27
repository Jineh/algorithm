package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G2258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] meat = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            meat[i][0] = Integer.parseInt(st.nextToken());
            meat[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meat, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });

        int totalP =0;
        int totalG =0;
        int answer = Integer.MAX_VALUE;
        int check =0;

        for(int i=0; i<n; i++){

            totalG += meat[i][0];
            if(i > 0 && meat[i-1][1] == meat[i][1]){ // 가격이 같지만 더 많은 무게의 고기를 얻을 수 있음
                totalP += meat[i][1];
            }
            else{ //많은 무게의 더 싼 고기가 있을 수 있음
                totalP = meat[i][1];
            }

            if(totalG >= m){
                check=1;
                answer = Math.min(answer, totalP);
            }
        }
        if(check==1){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }

    }
}