import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class S1288 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            int n =Integer.parseInt(br.readLine());
            int ans = find(n);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }

        System.out.println(sb);
    }

    static int find(int n){
        HashSet<Integer> check = new LinkedHashSet<>();
        for(int i=0; i<10; i++) check.add(i);

        int i=1;
        while(true){
            int tmp = n*i;
            int res = tmp;
            int d;
            while(tmp!=0){
                d = tmp%10;
                tmp = tmp/10;
                if(check.contains(d)) check.remove(d);
            }
            if(check.isEmpty()) return res;
            i++;
        }
    }
}
