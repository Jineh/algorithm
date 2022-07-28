package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String s = br.readLine();
            sb.append(palCheck(s, 0, 0, s.length()-1));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int palCheck(String s, int result, int start, int last) {

        if (result == 2) {
            return 2;
        }

        while (start < last) {
            if (s.charAt(start) == s.charAt(last)) {
                start++;
                last--;
            } else {
                result = Integer.min(palCheck(s, result+1, start+1, last), palCheck(s, result+1, start, last-1));
                break;
            }
        }
        return  result;
    }
}


