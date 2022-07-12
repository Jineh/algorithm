package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1931 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) { //음수되면 오른쪽 인자 아래로 이동

                if(o1[1] == o2[1]){
                    return o1[0] -o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count =0;
        int prev =0;

        for(int i=0; i<n; i++){

            if(prev <= time[i][0]){
                prev = time[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
