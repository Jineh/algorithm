public class P64062 {
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int min=1;
        int max= 200000000;

        while(min<= max){
            int mid = (min+max)/2;

            if(check(stones, mid, k)){
                answer = Math.max(answer, mid);
                min = mid+1;
            }
            else max = mid-1;
        }
        return answer;
    }

    static boolean check(int[] stones, int person, int k){
        int skip=0;
        for(int s: stones){
            if(s-person<0) skip++;
            else skip=0;

            if(skip==k) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int [] a = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(P64062.solution(a, 3));
    }
}
