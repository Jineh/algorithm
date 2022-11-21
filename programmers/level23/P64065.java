import java.util.ArrayList;
import java.util.Arrays;

public class P64065 {
    public static ArrayList<Integer> solution(String s) {

        s = s.substring(2, s.length());
        s = s.substring(0, s.length()-2).replace("},{","-");

        String str[] = s.split("-");
        Arrays.sort(str, (String s1, String s2)-> s1.length()-s2.length());

        ArrayList<Integer> answer = new ArrayList<>();

        for(String x : str){
            String[] tmp = x.split(",");

            for(int i=0; i<tmp.length; i++){
                int n = Integer.parseInt(tmp[i]);

                if(!answer.contains(n)) {
                    answer.add(n);
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        System.out.println(P64065.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }
}
