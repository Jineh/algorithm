package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G13019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer a = new StringBuffer(br.readLine());
        StringBuffer b = new StringBuffer(br.readLine());

        int[] num = new int[26];

        for(int i=0; i<a.length(); i++){
            num[a.charAt(i)-'A']++;
            num[b.charAt(i)-'A']--;
        }

        for(int i=0; i<26; i++){
            if(num[i]!=0){
                System.out.println(-1);
                return;
            }
        }


        int cnt =0;
        int pos =a.length()-1;
        int cur =pos;

        while(cur >=0 && pos >=0){
            if(b.charAt(cur) == a.charAt(pos)){
                cur--;
                cnt++;
            }
            pos--;

        }
        System.out.println(a.length()-cnt);
    }
}
