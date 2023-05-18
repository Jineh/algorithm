public class P87946 {
    int answer=0;
    public int solution(int k, int[][] dungeons) {
        boolean[] check = new boolean[dungeons.length];
        dfs(dungeons, check, k, 0);
        return answer;
    }

    public void dfs(int[][] dungeons, boolean[] check, int k, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i]){
                if(k<dungeons[i][0]) continue;
                int tmp = k-dungeons[i][1];
                check[i] = true;
                dfs(dungeons, check, tmp, cnt+1);
                answer = Math.max(cnt+1, answer);
                check[i] = false;
            }
        }
    }
}
