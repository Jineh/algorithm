import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S7701 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashSet<String> map = new LinkedHashSet<>();
            for(int i=0; i<n; i++){
                map.add(br.readLine());
            }
            List list = new ArrayList(map);
            Collections.sort(list, (Comparator<String>) (o1, o2) -> {
                if(o1.length()==o2.length()) return o1.compareTo(o2);
                else return o1.length()-o2.length();
            });
            sb.append('#').append(++cnt).append('\n');
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
