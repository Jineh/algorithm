package greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class G14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        int[][] Hi = new int[n][2];
        int[] j = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            Hi[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            Hi[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Hi, (a1, a2) -> a1[1] - a2[1]);
        long sum =0;
        for(int i=0; i<n; i++){
            sum += Hi[i][0] + (Hi[i][1] * i);
        }
        System.out.println(sum);
    }
}
