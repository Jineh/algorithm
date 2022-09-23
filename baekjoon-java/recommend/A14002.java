package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class A14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0]=1;
        int res=1;
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]+=1;
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);

        int value = res;
        // 경로를 역추적 할 stack
        Stack<Integer> stack = new Stack<>();

        // value는 현재 찾는 길이에 해당하는 값이다.
        for(int i = n-1; i >= 0; i--){
            // 현재 찾는 길이와 같은 경우
            if(value == dp[i]) {
                // stack에 실제 값을 push한다.
                stack.push(arr[i]);
                // 찾는 길이를 찾았으므로 -1을 해주어
                // 다음에 찾을 길이를 설정해준다.
                value--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }
}
