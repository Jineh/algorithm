import java.util.*;

public class P67258 {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new LinkedHashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        int min = Integer.MAX_VALUE;

        while(true){
            if(set.size()==map.size()){
                map.put(gems[left], map.get(gems[left])-1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
            else if(right==gems.length) break;
            else{
                map.put(gems[right], map.getOrDefault(gems[right],0)+1);
                right++;
            }

            if(map.size()==set.size()){
                if(right-left <min){
                    min = right-left;
                    answer[0]=left+1;
                    answer[1]=right;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(P67258.solution(a)));
    }
}
