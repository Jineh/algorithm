package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int size = 1;
        int cnt=0, size2 =0;

        while(size< k){
            size = size*2;
        }
        size2 = size;

        while(k>0){
            if(k>=size) k-=size;
            else{
                size /= 2;
                cnt++;
            }
        }


        System.out.println(size2+ " " + cnt);
    }
}
