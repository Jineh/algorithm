package binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] s = new String[n];
        for(int i=0; i<n; i++) s[i] = br.readLine();

        Arrays.sort(s);

        int res=0;
        for(int i=0; i<m; i++) {
            String str = br.readLine();
            if(find(s, str)) res++;
        }

        bw.write(String.valueOf(res));
        bw.close();
        br.close();
    }

    public static boolean find(String[] s, String str) {
        int start=0, end = s.length-1;

        while(start<=end) {
            int mid = (start + end)/2;
            int check = str.compareTo(s[mid]);

            if(check<0) end = mid -1;
            else if(check >0) start = mid +1;

            if(s[mid].startsWith(str)) return true;
        }

        return false;
    }
}
