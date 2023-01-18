import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class S13501 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m =Integer.parseInt(st.nextToken());
            int l =Integer.parseInt(st.nextToken());

            List<Integer> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            while(n-->0){
                list.add(Integer.parseInt(st.nextToken()));
            }

            while(m-->0){
                st = new StringTokenizer(br.readLine());
                String c = st.nextToken();
                if(c.equals("I")){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    list.add(x,y);
                }
                else if(c.equals("D")){
                    int x = Integer.parseInt(st.nextToken());
                    list.remove(x);
                }
                else{
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    list.set(x,y);
                }
            }
            int ans = list.size()<l? -1 : list.get(l);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
