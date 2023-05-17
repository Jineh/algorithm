import java.util.*;
import java.io.*;

    public class S1206 {
        public static void main(String args[]) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            for(int t=1; t<=10; t++){
                int n = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                int[] arr = new int[n];
                for(int i=0; i<n; i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                int res = find(arr);
                sb.append('#').append(t).append(" ").append(res).append('\n');
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }

        static int find(int[] arr){
            int cnt=0;
            for(int i=2; i<arr.length-2; i++){
                int tmp = arr[i];
                int min=256;
                min = Math.min(arr[i] - arr[i-2], min);
                min = Math.min(arr[i] - arr[i-1], min);
                min = Math.min(arr[i] - arr[i+1], min);
                min = Math.min(arr[i] - arr[i+2], min);
                if(min<0) continue;
                cnt+=min;
            }
            return cnt;
        }
    }
