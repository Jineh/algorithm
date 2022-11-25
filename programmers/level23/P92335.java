public class P92335 {
    public static int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k);
        String[] arr = str.split("0");

        for(String tmp : arr){
            if(!tmp.isEmpty()){
                if(prime(Long.parseLong(tmp))) answer++;
            }
        }

        return answer;

    }

    public static boolean prime(long num){
        if(num==1) return false;

        for(int i=2; i <= Math.sqrt(num); i++){
            if(num % i ==0) return false;
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(P92335.solution(110011, 10));
    }
}
