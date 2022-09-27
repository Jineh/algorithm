package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        String[] sub = br.readLine().split("-");

        for (int i = 0; i < sub.length; i++) {
            int temp =0;
            
            String[] add = sub[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }

//            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
//
//            // 덧셈으로 나뉜 토큰들을 모두 더한다.
//            while (addition.hasMoreTokens()) {
//                temp += Integer.parseInt(addition.nextToken());
//            }
            
            if(sum == Integer.MAX_VALUE){ //처음이면 양수여야 하니까
                sum = temp;
            }else{
                sum-=temp;
            }
        }
        System.out.println(sum);
    }
}
