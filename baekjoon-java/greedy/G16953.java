package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G16953 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a1 = Long.parseLong(st.nextToken());
        long b1 = Long.parseLong(st.nextToken());
        int cnt =1;

        while(a1 != b1) {
            if(a1> b1){
                cnt=-1;
                break;
            }

            if (b1 % 2 == 0) {
                b1 = b1 / 2;
            } else if(b1 % 10 ==1) {
                b1=b1/10;
            }
            else{
                cnt=-1;
                break;
            }
            cnt++;
        }


        System.out.println(cnt);
    }
}
