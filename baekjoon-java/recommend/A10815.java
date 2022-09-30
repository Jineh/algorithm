package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A10815 {
    static int[] nArr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        nArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <m; i++) {
            int my= Integer.parseInt(st.nextToken());
            sb.append(check(my)).append(" ");
        }

        System.out.println(sb);

    }

    static int check(int my){
        int low =0;
        int high = n-1;
        int mid;

        while(low<=high){
            mid = (low+high)/2;

            if(nArr[mid] == my) return 1;
            else if (nArr[mid] > my) high = mid-1;
            else low = mid+1;
        }

        return 0;
    }
}
