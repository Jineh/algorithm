package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class T2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long a = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        ArrayList<Long> d = new ArrayList<Long>();
        d.add(a);

        long sum=0;
        long n=0;
        while(true){
            n += (int) Math.pow(a%10, p);
            a/=10;
            if(a==0){
                if(d.indexOf(n)>-1){
                    System.out.println(d.indexOf(n));
                    return;
                }
                else{
                    d.add(n);
                    a=n;
                    n=0;
                }
            }
        }



    }
}
