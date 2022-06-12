import java.util.Arrays;

public class J77484 {

    class Solution{
        public int[] solution(int[] lottos, int[] win_nums){
            int[] answer = {};

            for (int i=0; i<lottos.length; i++){
                int idx = Arrays.binarySearch(win_nums, lottos[i]);
               if (idx>0){


               }
            }

            return answer;
        }
    }
}
