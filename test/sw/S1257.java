import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S1257 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int cnt = 0;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String arr[] = new String[str.length()];
            for(int i =0; i<str.length(); i++){
                arr[i] = str.substring(i);
            }
            Arrays.sort(arr);
            String ans=find(n, arr);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }


    static String find(int n, String[] arr){
        HashSet<String> check = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            String str = arr[i];
            for(int j=0; j<str.length(); j++){
                if(check.add(str.substring(0,j+1))) n--;
                if(n==0) return str.substring(0,j+1);
            }
        }
        return "none";
    }
}
