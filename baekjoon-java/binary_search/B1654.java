package binary_search;

import java.io.*;
import java.util.StringTokenizer;

public class B1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        long max=0;
        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max<arr[i]) max = arr[i];
        }

        long res = solution(arr, n, max);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    // Upper Bound
    public static long solution(int[] arr, int n, long max){
        long start=0, end=max+1, cnt, mid;

        while(start < end){
            cnt=0;
            mid = (start+end)/2;

            for(int i=0; i<arr.length; i++){
                cnt+=(arr[i]/mid);
            }

            if(cnt<n) end = mid;
            else start = mid+1;
        }

        return start-1;
    }
}
