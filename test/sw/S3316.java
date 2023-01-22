import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S3316 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        while (T-- > 0) {
            String str = br.readLine();
            int ans = find(str);
            sb.append('#').append(++cnt).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }


    static int find(String str) {
        int[][] dp = new int[str.length()][16];
        int master;

        for(int i=0; i<str.length(); i++){
           master = 1 << (str.charAt(i) - 'A');
            for(int j=1; j<16; j++){
                if(i==0){
                    if ((j & master) != 0 && (j & 'A') != 0) {
                        dp[i][j]++;
                    }
                }
                else if(dp[i-1][j]>0){
                    for(int k=1; k<16; k++){
                        if((j & k)!=0 && (k & master)!=0) {
                            dp[i][k] = (dp[i][k] + dp[i-1][j])%1000000007;
                        }
                    }
                }
            }
        }
        for(int i=1; i<16; i++){
            dp[str.length()-1][0]= (dp[str.length()-1][0] + dp[str.length()-1][i])%1000000007;
        }

        return dp[str.length()-1][0]%1000000007;
    }

}
