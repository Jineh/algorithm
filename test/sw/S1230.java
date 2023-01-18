import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class S1230 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringTokenizer st, st2;
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int m =Integer.parseInt(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            String ans = find(st, st2);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }

        System.out.println(sb);

    }

    static String find(StringTokenizer st, StringTokenizer st2){
        List<Integer> list = new LinkedList<>();
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        while(st2.hasMoreTokens()){
            String c = st2.nextToken();
            if(c.equals("I")){
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                while(y-->0){
                    int s = Integer.parseInt(st2.nextToken());
                    list.add(x++, s);
                }
            }
            else if(c.equals("D")){
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                while(y-->0){
                    list.remove(x++);
                }
            }
            else{
                int y = Integer.parseInt(st2.nextToken());
                while(y-->0){
                    int s = Integer.parseInt(st2.nextToken());
                    list.add(s);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            sb.append(list.get(i)).append(" ");
        }
        return sb.toString();
    }

}
