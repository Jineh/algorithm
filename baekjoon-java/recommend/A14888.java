package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A14888 {
    static int n;
    static int[] arr;
    static char[] y, ty;
    static char[] cal = {'.','+', '-', '*', '/'};
    static boolean[] v;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        y = new char[n];
        ty = new char[n];
        v= new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int tmp=1,next=0 ;
        for(int i=1; i<=4; i++){
            int a =Integer.parseInt(st.nextToken());
            next=tmp+a;
            Arrays.fill(y,tmp, next, cal[i]);
            tmp=next;

        }


        solve(1);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int cnt){
        if(cnt==n){
            int sum=arr[1];
            for(int i=1; i<n; i++){
                if(ty[i]=='+'){
                    sum += + arr[i+1];
                }
                else if(ty[i]=='-'){
                    sum -= arr[i+1];
                }
                else if(ty[i]=='*'){
                    sum *= arr[i+1];
                }
                else if(ty[i]=='/'){
                    if(sum<0) {
                        sum = Math.abs(sum);
                        sum/=arr[i+1];
                        sum*=-1;
                    }
                    else {
                        sum /= arr[i+1];
                    }
                }
            }
            if(sum>max) max=sum;
            if(sum<min) min=sum;
            return;
        }

        for(int i=1; i<n; i++){
            if(v[i]) continue;
            v[i] = true;
            ty[cnt] = y[i];
            solve(cnt+1);
            v[i] = false;
        }

    }
}
