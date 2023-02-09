import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class S1233 {
    static int ans=1;
    static Stack<String> stack;
    static ArrayList<String> number = new ArrayList(Arrays.asList("1","2","3","4","5","6","7","8","9"));
    static ArrayList<String> cal = new ArrayList(Arrays.asList("-","+","/","*"));
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n+1];
            stack = new Stack<>();
            ans=1;
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
        if(next>arr.length-1 || ans==0) return;

        find(next<<1, arr);
        if(!stack.isEmpty()){
            String str = stack.pop();
            if(number.contains(arr[next]) && number.contains(str)) {
                ans=0;
                return;
            }
            else if(cal.contains(arr[next]) && cal.contains(str)) {
                ans=0;
                return;
            }
        }
        stack.push(arr[next]);
        find((next<<1)+1, arr);
    }
}
