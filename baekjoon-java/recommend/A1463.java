package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class A1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        int cnt=-1;
        while(!q.isEmpty()){
            int len = q.size();
            cnt++;
            while(len-->0){
                int tmp = q.poll();
                if(tmp==1) {
                    System.out.println(cnt);
                    return;
                }
                if(tmp%3==0) q.offer(tmp/3);
                if(tmp%2==0) q.offer(tmp/2);
                q.offer(tmp-1);
            }
        }
    }
}
