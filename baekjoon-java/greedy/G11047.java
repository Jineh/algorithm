package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class G11047 {
    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        int[] coin = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            coin[i] = sc.nextInt();
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];

        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count =0;

        for (int i = n - 1; i >= 0; i--) {

            if(coin[i] <=k){
                count += (k / coin[i]);
                k = k % coin[i];
            }
        }
        System.out.println(count);
    }
}