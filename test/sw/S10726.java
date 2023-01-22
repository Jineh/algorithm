import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10726 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String ans = find(n, m);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }

        System.out.println(sb);

    }

    static String find(int n, int m){
        int d, i=0;
        while(m!=0){
            d = m & ((1<<1)-1);
            m = m >> 1;
            i++;
            if(d==0) break;
            if(i==n) return "ON";
        }
        return "OFF";
    }

}
