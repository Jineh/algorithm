public class P12971 {
    public static int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];

        int[] dp = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = dp[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];


        for(int i=2; i<sticker.length-1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+sticker[i]);
        }

        for(int i=2; i<sticker.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i]);
        }


        return Math.max(dp[sticker.length-2],dp2[sticker.length-1]);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 4};
        System.out.println(P12971.solution( a));
    }
}
