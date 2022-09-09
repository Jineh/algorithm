package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(arr, n, m));
    }

    static int solve(int[] arr, int n, int m){
        int result =0;

        for(int i=0; i<n-2; i++){

            if(arr[i] > m) continue;

            for(int j=i+1; j<n-1; j++){

                if(arr[i] + arr[j] > m) continue;

                for(int k=j+1; k<n; k++){

                    int tmp = arr[i]+arr[j]+arr[k];

                    if(m==tmp) return tmp;

                    if(result < tmp && tmp <m) result = tmp;
                }
            }
        }
        return result;
    }
}
