import java.util.Arrays;

public class P12987 {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int j=0;
        for(int i=0; i<A.length; i++){
            int check = A[i];

            while(j!=B.length){
                if(check<B[j]) {
                    B[j]=0;
                    answer++;
                    j++;
                    break;
                }
                j++;
            }

            if(j==B.length) break;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] a ={5,1,3,7};
        int[] b = {2,3,6,8};
        System.out.println(P12987.solution(a, b));
    }
}
