public class P42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        int cur = Integer.MIN_VALUE;

        Arrays.sort(routes, (a1, a2) -> a1[1] - a2[1]);
        for(int[] tmp : routes){
            if(tmp[0] > cur){
                answer++;
                cur = tmp[1];
            }
        }
        return answer;
    }
}
