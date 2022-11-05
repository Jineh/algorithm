public class P42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for(int i=3; i<sum; i++){
            if(sum%i==0){
                int c = i-2;
                int r = sum/i-2;

                if(c*r==yellow){
                    answer[0]=r+2;
                    answer[1]=c+2;
                    break;
                }
            }
        }

        return answer;
    }
}
