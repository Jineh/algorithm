import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P49189 {
    public int solution(int n, int[][] edge) {

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        boolean[] check = new boolean[n+1];

        for(int i=0; i<=n; i++){
            map.add(new ArrayList<>());
        }

        for(int[] tmp : edge){
            map.get(tmp[0]).add(tmp[1]);
            map.get(tmp[1]).add(tmp[0]);
        }

        return bfs(map, check);
    }

    public int bfs (ArrayList<ArrayList<Integer>> map, boolean[] check){
        Queue<int[]> queue = new LinkedList<>();
        int max=0, cnt=0;

        queue.offer(new int[] {1,0});
        check[1] = true;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();

            if(max<tmp[1]){
                max = tmp[1];
                cnt=1;
            }
            else if(max == tmp[1]) cnt++;

            for(int i=0; i<map.get(tmp[0]).size(); i++){
                int cur = map.get(tmp[0]).get(i);
                if(check[cur]) continue;

                check[cur] = true;
                queue.offer(new int[] {cur, tmp[1]+1});
            }
        }

        return cnt;
    }
}
