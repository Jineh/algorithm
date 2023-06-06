package binary_search;

import java.io.*;
import java.util.*;

public class B6236{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int start=0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            start= Math.max(start, arr[i]);
        }

        int res=0;
        int  end = 10000 * 100000;
        while(start<=end){
            int mid = (start+end)/2;
            int cnt=1, money = mid;
            for(int i=0; i<n; i++){
                if(money<arr[i]){
                    cnt++;
                    money=mid;
                }
                money-=arr[i];
            }
            if(cnt>m) start = mid+1;
            else {
                res = mid;
                end = mid-1;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
