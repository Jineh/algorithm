package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G1464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();

        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for(int i=0; i<s.length; i++){
            int check = a.append(s[i]).compareTo(b.insert(0, s[i]));
            if(check<=0) b = new StringBuilder(a.toString());
            else a = new StringBuilder(b.toString());

        }
        System.out.println(a.toString());
    }
}
