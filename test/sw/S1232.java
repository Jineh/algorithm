import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S1232 {
    static String[] val;
    static Stack<Integer> stack;
    static int[][] tree;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            stack = new Stack<>();
            val = new String[n + 1];
            tree = new int[n + 1][2];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String str = st.nextToken();
                val[num] = str;

                if (str.equals("-") || str.equals("+") || str.equals("*") || str.equals("/")) {
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    tree[num][0] = l;
                    tree[num][1] = r;
                }
            }
            find(1);
            int ans = stack.pop();
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }

        System.out.println(sb);

    }


    static void find(int next) {
        if (tree[next][0] == 0 && tree[next][1] == 0) {
            stack.push(Integer.valueOf(val[next]));
            return;
        }
        find(tree[next][0]);
        find(tree[next][1]);
        cal(val[next]);
    }


    static void cal(String s) {
        int y = stack.pop();
        int x = stack.pop();
        if (s.equals("-")) stack.push(x - y);
        else if (s.equals("+")) stack.push(x + y);
        else if (s.equals("*")) stack.push(x * y);
        else stack.push(x / y);
    }
}
