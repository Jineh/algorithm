package greedy;

import java.util.Arrays;

public class G42862 {
    static class Solution {
        public static int solution(int n, int[] lost, int[] reserve) {
            int answer = n - lost.length;

            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i=0; i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if(lost[i] == reserve[j]){
                        answer++;
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            for(int i=0; i<lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                        answer++;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {

        int[] l = {2, 4};
        int[] r = {1, 3, 5};

        System.out.println(Solution.solution(5, l, r));
    }
}
