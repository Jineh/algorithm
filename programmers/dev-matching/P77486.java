import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P77486 {
   static class Solution {
        public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];

            Map<String, String> parent = new HashMap<>();
            Map<String, Integer> enrollIndex = new HashMap<>();

            for(int i=0; i<enroll.length; i++){
                parent.put(enroll[i], referral[i]);
                enrollIndex.put(enroll[i], i);
            }


            for(int i=0; i<seller.length; i++) {
                String now = seller[i];
                int profit = amount[i]*100;


                while(!now.equals("-")){
                    int parentProfit = profit/10;
                    int nowProfit = profit-parentProfit;

                    answer[enrollIndex.get(now)] += nowProfit;

                    now = parent.get(now);
                    profit = parentProfit;

                    if(profit<1){ //1원 미만이면 적을 필요가 없음
                        break;
                    }

                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {

        String[] e = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] r = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] s = {"young", "john", "tod", "emily", "mary"};
        int[] a = {12, 4, 2, 5, 10};
        P77486.Solution.solution(e, r, s, a);
    }
}
