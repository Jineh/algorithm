package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class G2036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        BigInteger sum = new BigInteger("0");
        for(int i=0; i<n; i++) {
            if(num[i]>0) break;
            else if(i+1 == n) {
                sum = sum.add(BigInteger.valueOf(num[i]));
                break;
            }
            else if(num[i] * num[i+1] >=0){
                sum = sum.add(BigInteger.valueOf(num[i] * num[i+1]));
                i++;
                continue;
            }
            else sum = sum.add(BigInteger.valueOf(num[i]));
        }

        for(int i=n-1; i>=0; i--){
            if(num[i] <0) break;
            else if (i==0){
                sum = sum.add(BigInteger.valueOf(num[i]));
                break;
            }
            else if(num[i] * num[i-1] >0 && num[i] * num[i-1] > num[i] + num[i-1]){
                sum = sum.add(BigInteger.valueOf(num[i] * num[i-1]));
                i--;
                continue;
            }
            else sum = sum.add(BigInteger.valueOf(num[i]));
        }
        System.out.println(sum);
    }
}
