import java.util.*;

public class P72411 {
    static HashMap<String, Integer> map = new HashMap<>();
    static List<String> aList = new ArrayList<>();
    public static String[] solution(String[] orders, int[] course) {

        for(int i=0; i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for(int c : course){
            for(String s: orders){
                StringBuilder sb = new StringBuilder();
                combi("", s, c);
            }
            if(!map.isEmpty()){
                List<Integer> cnt = new ArrayList<>(map.values());
                int max = Collections.max(cnt);

                if(max>1){
                    for(String key: map.keySet()){
                        if(map.get(key)==max) aList.add(key);
                    }
                    map.clear();
                }
            }
        }

        Collections.sort(aList);
        String[] answer = new String[aList.size()];
        for(int i=0; i<answer.length; i++) answer[i] = aList.get(i);
        return answer;
    }

    static void combi(String order , String others, int cnt){
        if(cnt==0){
            map.put(order, map.getOrDefault(order, 0)+1);
            return;
        }
        for(int i=0; i<others.length(); i++){
            combi(order+others.charAt(i), others.substring(i+1), cnt-1);
        }
    }


    public static void main(String[] args) {
        String[] b= {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] a = {2,3,4};
        System.out.println(P72411.solution(b, a));
    }
}
