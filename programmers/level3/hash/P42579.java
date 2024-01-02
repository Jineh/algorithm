import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class P42579 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map  = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<String>(){
            public int compare(String o1, String o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });


        for(String key : keySet){
            List<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(key)){
                    list.add(new Music(i, plays[i]));
                }
            }
            Collections.sort(list, (o1, o2) -> (o2.py-o1.py));
            answer.add(list.get(0).idx);
            if(list.size()>1) answer.add(list.get(1).idx);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    class Music{
        int idx;
        int py;

        Music(int idx, int py){
            this.idx = idx;
            this.py = py;
        }
    }
}

