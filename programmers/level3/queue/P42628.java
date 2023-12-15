import java.util.PriorityQueue;
import java.util.Collections;
import java.util.StringTokenizer;

public class P42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        for(String op : operations){
            StringTokenizer st = new StringTokenizer(op);
            String ac = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(ac.equals("I")){
                pqMin.offer(num);
                pqMax.offer(num);
            }
            else if(pqMax.isEmpty()) continue;
            else if(num == 1){
                int rm = pqMax.poll();
                pqMin.remove(rm);
            }
            else{
                int rm = pqMin.poll();
                pqMax.remove(rm);
            }
        }

        if(!pqMax.isEmpty()){
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }
        return answer;
    }
}
