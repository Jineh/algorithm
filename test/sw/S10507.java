import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10507 {
    static boolean[] check;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int cnt = 0;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            check = new boolean[1000001];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                check[arr[i]] = true;
            }
            int ans = find( p, arr[n-1], arr[0]);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int p, int finish, int s){
        int res=0, start=s, end=s;
        int day=0;
        while(end<=finish){
            if(check[end]){
                day++;
                end++;
                res = Math.max(day, res);
            }
            else{
                if(p==0){
                    res = Math.max(day, res);
                    if(!check[start]) p++;
                    start++;
                    day--;
                }
                else{
                    end++;
                    day++;
                    p--;
                }
            }
        }
        if(p>0) res+=p;
        return res;
    }
}
