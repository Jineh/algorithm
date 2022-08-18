package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T13549 {
    static int n, k;
    static boolean[] check;
    static Queue<int []> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        check = new boolean[100001];
        q.offer(new int[] {n, 0}); //수빈이의 위치, 현재 시간 같이 저장
        bfs();

    }

    static void bfs(){
        while(!q.isEmpty()){
            int len = q.size();
            while(len-- >0){
                int[] tmp = q.poll();

                if(tmp[0]==k){
                    System.out.println(tmp[1]);
                    return;
                }

                check[tmp[0]]=true;
                int p = tmp[0]+1;
                int m = tmp[0]-1;
                int d = tmp[0]*2;

                if(d>=0 && d<=100000 && !check[d]){
                    check[d] = true;
                    q.offer(new int[] {d, tmp[1]}); //순간 이동일 때는 시간 더하지 x
                }
                if(m >=0 && !check[m]){
                    check[m] = true;
                    q.offer(new int[] {m, tmp[1]+1});
                }
                if(p<=100000 && !check[p]){
                    check[p] = true;
                    q.offer(new int[] {p, tmp[1]+1});
                }

            }
        }

    }
}

