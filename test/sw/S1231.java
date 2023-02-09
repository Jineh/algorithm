import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1231 {
    static StringBuilder ans;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n+1];
            ans = new StringBuilder();

            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                arr[num] = st.nextToken();
            }
            find(1, arr);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }

        System.out.println(sb);

    }


    static void  find(int next , String[] arr){
        if(next>arr.length-1) return;

        find(next<<1, arr);
        ans.append(arr[next]);
        find((next<<1)+1, arr);
    }
}
