public class P43105 {
        public int solution(int[][] triangle) {
            int answer = 0;

            int dp[][] = new int[triangle.length][];
            for(int i=triangle.length-1; i>=0; i--){
                dp[i] = new int[triangle[i].length];

                for(int j=0; j<triangle[i].length; j++){
                    if(i==triangle.length-1){
                        for(int k=0; k<triangle[i].length; k++)
                            dp[i][k] = triangle[i][k];
                    }
                    else{
                        int left = dp[i+1][j] + triangle[i][j];
                        int right = dp[i+1][j+1] + triangle[i][j];
                        dp[i][j] = Math.max(left, right);
                    }
                }
            }

            answer = dp[0][0];

            return answer;
        }

}
