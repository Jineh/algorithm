package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] person = new long[n][2];
        StringTokenizer st;
        long total =0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
            total+=person[i][1];
        }

        Arrays.sort(person, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0] == o2[0]) return (int) (o1[1] - o2[1]);
                return (int) (o1[0] - o2[0]);
            }
        });


        long sum=0;
        for(int i=0; i<n; i++){
            sum+=person[i][1];
            if(sum>= (total+1)/2){ //인구수가 많은 쪽에 설치
                System.out.println(person[i][0]);
                break;
            }
        }

    }
}
