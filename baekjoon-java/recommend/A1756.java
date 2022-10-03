package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1756 {
    static int[] arr;
    static int dep, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[d];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<d; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i!=0 && arr[i-1]<arr[i]) arr[i] = arr[i-1];
        }

        dep = d -1;
        min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int pizza = Integer.parseInt(st.nextToken());
            binary(pizza,dep);
        }
        min++;
        System.out.println(min);

    }

    static void binary(int pizza, int down){
        int res = -1;
        int up=0;
        while(up <= down){
            int mid = (up+down)/2;
            if(arr[mid] >= pizza){
                res = mid;
                up = mid + 1;
            }
            else{
                down = mid -1;
            }
        }
        min = res;
        dep = res-1;
    }
}
