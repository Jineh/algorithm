public class P12938 {
    public int[] solution(int n, int s) {
        int[] answer;

        if (n > s) answer = new int[] {-1};
        else{
            answer = new int[n];
            int mod = s%n;
            int ans= s/n;

            for(int i=0; i<n; i++){
                answer[i] = ans;
            }

            if(mod!=0){
                while(mod!=0){
                    answer[--n]++;
                    mod--;
                }
            }

        }
        return answer;
    }
}