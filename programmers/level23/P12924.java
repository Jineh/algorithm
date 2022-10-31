public class P12924 {
    public static int solution(int n) {
        int answer = 0;

        for(int j=1; j<=n; j++){
            int sum=0;
            for(int i=j; i<=n; i++){
                sum+=i;
                if(sum==n){
                    answer++;
                    break;
                }
                else if(sum>n) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int n =15;
        System.out.println(P12924.solution(n));
    }
}
