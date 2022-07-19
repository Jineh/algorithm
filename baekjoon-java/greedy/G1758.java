package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G1758 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Integer[] person = new Integer[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            person[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person, Comparator.reverseOrder());
        long res =0;


        for (int i = 0; i < n; i++) {
            if(person[i]-i <=0){
                break;
            }
            res+=person[i]-i;
        }

        System.out.println(res);

    }
}
