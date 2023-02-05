import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S8898 {
    static int min;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int[] cow = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cow[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cow);

            int cnt=0, check, val;
            min=Integer.MAX_VALUE;
            int horse;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                horse = Integer.parseInt(st.nextToken());
                check = min;
                val = binary(cow, horse);
                if(check> min) cnt=val;
                else if(check==min) cnt+=val;
            }
            int dist =Math.abs(c1-c2)+min;
            sb.append('#').append(tc).append(" ").append(dist).append(" ").append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static int binary(int[] cow, int horse){
        int start =0, end = cow.length, cur;
        int mid, val, tmp=-1, cnt=0;
        while(start != end){
            mid = start + ((end-start)>>1);
            cur = cow[mid];
            val =Math.abs(cur-horse);
            if(cur<horse){
                start = mid+1;
            }
            else{
                end = mid;
            }
            if(min>=val) {
                min = val;
                tmp=mid;
            }
        }
        if(tmp!=-1){
            cnt=1;
            if(tmp>0){
                if(Math.abs(cow[tmp-1]-horse)==min) cnt++;
            }
            if(tmp<cow.length-1){
                if(Math.abs(cow[tmp+1]-horse)==min) cnt++;
            }
        }
        return cnt;
    }
}
