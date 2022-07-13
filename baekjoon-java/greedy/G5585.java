package greedy;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int res = 1000-n;

        int[] coin = {500, 100, 50, 10, 5, 1};

        int count =0;

        for (int i = 0; i < coin.length; i++) {
            if(res % coin[i]!=res){
                count += res/coin[i];
                res = res % coin[i];
            }
        }
        System.out.println(count);
    }
}
