package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G11508 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Integer[] coin = new Integer[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coin, Comparator.reverseOrder());
        long res =0;

        for(int i=0; i<n; i++){
            if((i+1)%3!=0){
                res +=coin[i];
            }
        }
        System.out.println(res);

    }
}
