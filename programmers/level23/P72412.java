import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P72412 {

    static HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    static boolean [] check = new boolean[4];
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(String s : info){
            String [] iSplit = s.split(" ");
            comb(iSplit, 0);
        }
        for(String key: map.keySet()){
            Collections.sort(map.get(key));
        }

        for(int i=0; i<query.length; i++){
            String q = query[i];
            q = q.replace(" and", "");
            String[] qSplit = q.split(" ");
            q="";
            for(int j=0; j<4; j++){
                q+= qSplit[j].equals("-")?"" : qSplit[j];
            }
            int score = Integer.parseInt(qSplit[4]);
            List<Integer> scoreList = map.getOrDefault(q, new ArrayList<Integer>());
            int s =0, l = scoreList.size();
            while(s<l){
                int mid = (s+l)/2;
                if(scoreList.get(mid) < score) s = mid+1;
                else l = mid;
            }
            //s 값은 조건보다 낮은 점수의 사람들 이것을 전체에서 빼면 조건 맞음
            answer[i] = scoreList.size() - s;
        }
        return answer;
    }

    public static void comb(String[] info, int step){
        if(step==4){
            StringBuilder str = new StringBuilder();
            for(int i=0; i<4; i++){
                str.append(check[i] ? info[i] : "");
            }
            map.put(str.toString(), map.getOrDefault(str.toString(), new ArrayList<>()));
            map.get(str.toString()).add(Integer.parseInt(info[step]));
            return;
        }
        //조건을 추가하기, 빼기
        check[step] = true;
        comb(info, step+1);
        check[step] = false;
        comb(info, step+1);
    }


    public static void main(String[] args) {

        String[] a ={"java backend junior pizza 150","python frontend senior chicken 210",
                "python frontend senior chicken 150","cpp backend senior pizza 260",
                "java backend junior chicken 80","python backend senior chicken 50"};
        String[] b = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250","- and backend and senior and - 150",
                "- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(P72412.solution(a, b));
    }
}
