package recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B1759 {
    public static ArrayList<Character> mo = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String[] arr = new String[c];

        for(int i=0; i<c; i++) arr[i] = st.nextToken();
        Arrays.sort(arr);
        boolean[] visit = new boolean[c];
        dfs(0,"", l, arr);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int start, String str, int l, String[] arr){
        if(str.length()==l){
            if(check(str)) sb.append(str).append('\n');
            return;
        }
        for(int i=start; i<arr.length; i++) {
            dfs(i + 1, str + arr[i], l, arr);
        }
    }

    public static boolean check(String str){
        int c1=0, c2;
        for(int i=0; i<str.length(); i++){
            if(mo.contains(str.charAt(i))) c1++;
        }
        c2= str.length()-c1;
        if(c1>0 && c2>1) return true;
        return false;
    }
}
