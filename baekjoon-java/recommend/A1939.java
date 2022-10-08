package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1939 {
    static int n,m, a, b;
    static ArrayList<Node> list[];
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        int max =0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            max = Math.max(cost, max);
            min = Math.min(cost, min);
            list[x].add(new Node(y, cost));
            list[y].add(new Node(x, cost));
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());


        int res=0;
        while(min <= max){
            int mid = (min+max)/2;
            check = new boolean[n+1];

            if(bfs(mid)){
                min = mid+1;
                res = mid;
            }
            else{
                max = mid-1;
            }
        }

        System.out.println(res);

    }

    public static boolean bfs(int mid){
        Queue<Integer> q = new LinkedList<>();
        check[a] = true;
        q.offer(a);

        while(!q.isEmpty()){
            int tmp = q.poll();

            if(tmp == b) return true;

            for(int i=0; i<list[tmp].size(); i++){
                //같은 섬에서 여러 다리가 있을 수 있다.
                if(list[tmp].get(i).cost >=mid && !check[list[tmp].get(i).n]){
                    check[list[tmp].get(i).n] = true;
                    q.offer(list[tmp].get(i).n);
                }
            }
        }
        return false;
    }

    public static class Node{
        int n;
        int cost;

        public Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
    }
}
