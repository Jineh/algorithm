package brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class B1107 {
    public static int min;
    public static int max = 500000;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[10];

        if(m!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int i = Integer.parseInt(st.nextToken());
                button[i] = true;
            }
        }

        min = Math.abs(n-100);
        int size = String.valueOf(n).length();
        int[] cnt = new int[6];

        if(min!=0) find(button, cnt, n, 0, size);

        bw.write(String.valueOf(min));
        bw.close();
        br.close();
    }


    public static void find(boolean[] button, int[] cnt, int n, int idx, int size){
        if(idx>5) return;

        for(int i=0; i<10; i++){
            if(button[i]) continue;
            cnt[idx] = i;

            int res = count(cnt, n, idx) + idx +1;
            min = Math.min(res, min);

            find(button, cnt, n, idx+1, size);
        }
    }


    public static int count(int[] cnt, int n, int idx){
        int total=0;
        for (int i=0; i<=idx; i++) {
            total = total * 10 + cnt[i];
        }
        return Math.abs(total - n);
    }
}
