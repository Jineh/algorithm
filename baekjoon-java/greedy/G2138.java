package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2138 {
    static char before[][];
    static char after[];
    static int n;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        before = new char[2][n];
        before[0] = br.readLine().toCharArray();
        after = br.readLine().toCharArray();

        for(int i = 0; i < n; i++) {
            before[1][i] = before[0][i];
        }

        bulb(0, 1, 0); //첫번째

        turnOnOff(1, 0); //두번째  0번째 전구 킴
        bulb(1, 1, 1); //두번째

        System.out.print(result==Integer.MAX_VALUE?-1:result);
    }

    static void turnOnOff(int cur, int ind) {
        for(int i = ind-1; i < ind+2; i++) {
            if(-1 < i && i < n) {
                before[cur][i] = before[cur][i]=='1'?'0':'1';
            }
        }
    }

    static void bulb(int cur, int ind, int count) {
        if(ind == n) {                              // 0번째 끈 경우, 켠 경우 최솟값 비교
            if(before[cur][ind-1] == after[ind-1]) result = Math.min(result, count);
        }else {
            if(before[cur][ind-1] != after[ind-1]) {
                turnOnOff(cur, ind); //다르면 전구 온/오프하고 카운트 +1
                bulb(cur, ind+1, count+1);
            }else {
                bulb(cur, ind+1, count); //같으면 다음 전구로 이동 카운트 X
            }
        }
    }
}
