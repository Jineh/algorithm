package binary_search;

import java.io.*;
import java.util.*;

public class B2805{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long end=0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>end) end = arr[i];
        }

        long start=0, res=0;
        while(start<=end){
            long mid = (start+end)/2;
            long cnt =0;

            for(int i=0; i<n; i++){
                if(arr[i]>mid) cnt+=arr[i]-mid;
            }

            if(cnt<m) end = mid -1;
            else {
                res = mid;
                start = mid+1;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
