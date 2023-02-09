import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S1248 {
    static int[][] tree;
    static HashMap<Integer, Integer> map;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree = new int [v+1][2];
            map = new LinkedHashMap<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<e; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(tree[a][0]==0) tree[a][0]=b;
                else tree[a][1]=b;
                map.put(b,a);
            }
            int ans = find(x,y);
            int ans2 = dfs(ans);
            sb.append('#').append(++cnt).append(" ").append(ans)
                    .append(" ").append(ans2).append('\n');
        }
        System.out.println(sb);
    }

    static int find(int x, int y){
        HashSet<Integer> set = new LinkedHashSet<>();
        while(x!=y){
            if(x!=1) {
                x = map.get(x);
                if(!set.add(x)) break;
            }
            if(y!=1) {
                y = map.get(y);
                if(!set.add(y)){
                    x=y;
                    break;
                }
            }
        }
        return x;
    }

    static int dfs(int next){
        if(next==0) return 0;
        if(tree[next][0]==0 && tree[next][1]==0) return 1;
        return dfs(tree[next][0])+dfs(tree[next][1])+1;
    }
}
