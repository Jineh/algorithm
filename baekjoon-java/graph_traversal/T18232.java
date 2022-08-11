package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T18232 {
    static int n,m, s,e;
    static boolean [] check;
    static ArrayList<Integer>[] arr;
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        check = new boolean[n+1];

        for(int i=0; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int x,y;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        check[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int cnt=0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                int temp = q.poll();
                if(temp==e){
                    System.out.println(cnt);
                    return;
                }
                if(1<=temp-1 && temp-1<=n && !check[temp-1]){
                    check[temp-1] = true;
                    q.offer(temp-1);
                }
                if(1<=temp+1 && temp+1<=n && !check[temp+1]){
                    check[temp+1] = true;
                    q.offer(temp+1);
                }
                for(int item: arr[temp]){
                    if(1<=item && item<=n && !check[item]){
                        check[item] = true;
                        q.offer(item);
                    }
                }
            }
            cnt++;
        }

    }
}
