package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i]= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, Comparator.reverseOrder());

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += a[i] * b[i];
        }

        System.out.println(res);
    }
}
