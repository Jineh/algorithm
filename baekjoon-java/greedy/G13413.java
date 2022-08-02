package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer("");

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int wcnt = 0;
            int bcnt = 0;

            String start = br.readLine();
            String want = br.readLine();

            for (int k = 0; k < n; k++) {
                if (start.charAt(k) != want.charAt(k)) {
                    if (start.charAt(k) == 'W') bcnt++;
                    else wcnt++;
                }
            }

            if (bcnt >= wcnt) sb.append(bcnt);
            else sb.append(wcnt);

            sb.append("\n");

        }
        System.out.println(sb);
    }

}
