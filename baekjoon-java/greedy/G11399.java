package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G11399 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] person = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            person[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person);
        int sum=person[0];

        for(int i=1; i<n; i++){
            sum+= person[i]+person[i-1];
            person[i] = person[i]+person[i-1];
        }

        System.out.println(sum);

    }
}
