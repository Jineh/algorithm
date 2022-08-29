package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d1[0] = 1;
        d2[0] = 1;
        int max=1;
        for(int i=1; i<n; i++){
            if(arr[i-1] < arr[i]) {
                d1[i]+=d1[i-1]+1;
                d2[i]=1;
            }
            else if(arr[i-1]> arr[i]) {
                d2[i]+=d2[i-1]+1;
                d1[i]=1;
            }
            else {
                d1[i]+=d1[i-1]+1;
                d2[i]+=d2[i-1]+1;
            }
            max = Math.max(max, Math.max(d1[i], d2[i]));
        }
        System.out.println(max);

    }
}
