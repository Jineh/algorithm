import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S14733 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] arr = new int[n+1];
            long[] seg = new long[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                if((i&1)==1) arr[i] = Integer.parseInt(st.nextToken());
                else arr[i] = -Integer.parseInt(st.nextToken());
                change(i, arr[i], seg);
            }


            bw.write("#" + tc);
            while(q-->0){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken())+1;
                int b = Integer.parseInt(st.nextToken());
                if(c==1){
                    bw.write(" "+find(a, b, seg));
                }
                else{
                    if((a&1)==1){
                        change(a, b-arr[a], seg);
                        arr[a] = b;
                    }
                    else{
                        change(a, -(b+arr[a]), seg);
                        arr[a] = -b;
                    }
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }


    static long p_sum(int i, long[] seg){
        long res=0;
        while(i>0){
            res+=seg[i];
            i-=(i&-i);
        }
        return res;
    }
    static long find(int l, int r, long[] seg){
        long res =p_sum(r, seg) - p_sum(l-1, seg);
        if((l&1)==0) res = -res;
        return res;
    }

    static void change(int i, int x, long[] seg){
        while(i<seg.length){
            seg[i]+= x;
            i+=(i&-i);
        }
    }
}
