import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S14726 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[][] seg = new int[n<<1][2];
            init(arr, seg, n);

            sb.append('#').append(tc);
            while(q-->0){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(c==1){
                    sb.append(" ").append(find(a, b, seg, n));
                }
                else{
                    change(a, b, seg, n);
                }
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void init(int[] arr, int[][] seg, int n){
        for(int i=0; i<n; i++){
            seg[i+n][0] = arr[i];
            seg[i+n][1] = arr[i];
        }

        for(int i= n-1; i!=0; i--){
            seg[i][0] = Math.max(seg[i<<1][0] , seg[i<<1|1][0]);
            seg[i][1] = Math.min(seg[i<<1][1] , seg[i<<1|1][1]);
        }
    }

    static int find(int l, int r, int[][] seg, int n){
        int min = Integer.MAX_VALUE, max = -1;

        for(l+=n, r+=n; l!=r; l>>=1, r>>=1){
            if((l&1)==1){
                max = Math.max(seg[l][0], max);
                min = Math.min(seg[l++][1], min);
            }
            if((r&1)==1){
                max = Math.max(seg[--r][0], max);
                min = Math.min(seg[r][1], min);
            }
        }
        return max-min;
    }

    static void change(int i, int x, int[][] seg, int n){
        seg[i+=n][0] = x;
        seg[i][1] = x;
        while((i>>=1)!=0){
            seg[i][0] = Math.max(seg[i<<1][0] , seg[i<<1|1][0]);
            seg[i][1] = Math.min(seg[i<<1][1] , seg[i<<1|1][1]);
        }
    }
}
