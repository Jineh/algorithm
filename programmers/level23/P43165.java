public class P43165 {
    int answer=0;
    public int solution(int[] numbers, int target) {
        dfs(false, numbers[0], 0, 0, target, numbers);
        dfs(true, numbers[0], 0, 0, target, numbers);
        return answer;
    }

    public void dfs(boolean cal, int tmp, int cnt, int cur, int target, int[] numbers){
        if(cal) cur+=tmp;
        else cur-=tmp;
        if(cnt==numbers.length-1){
            if(cur==target) answer++;
            return;
        }
        dfs(false, numbers[cnt+1], cnt+1, cur, target, numbers);
        dfs(true, numbers[cnt+1], cnt+1, cur, target, numbers);
    }
}
