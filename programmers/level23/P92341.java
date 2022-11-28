import java.util.*;

public class P92341 {
    static HashMap<String, String> in = new LinkedHashMap<>();
    static HashMap<Integer, Integer> out = new LinkedHashMap<>();
    public static int[] solution(int[] fees, String[] records) {

        for(String s : records){
            String[] str = s.split(" ");
            if(str[2].equals("IN")) in.put(str[1], str[0]);
            else {
                outTimer(str);       //keySet() 사용 중에 키를 삭제 x
                in.remove(str[1]);   // 동시성 오류가 발생하여 런타임 오류 발생
            }
        }

        for(String key : in.keySet()){
            String[] str = {"23:59", key};
            outTimer(str);
        }

        List<Integer> keySet = new ArrayList<>(out.keySet());
        Collections.sort(keySet);
        int[] answer = new int[keySet.size()];
        int i=0;
        for(Integer key : keySet){
            int time = out.get(key);
            if(time<=fees[0]) answer[i] = fees[1];
            else{
                int cal = (int)Math.ceil((time-fees[0])/(double) fees[2]);
                answer[i] = fees[1] + cal *fees[3];
            }
            i++;
        }

        return answer;
    }

    public static void outTimer(String[] str){

        String[] start = in.get(str[1]).split(":");
        String[] end = str[0].split(":");
        int s_time = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
        int e_time = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]);

        int key = Integer.parseInt(str[1]);
        if(out.containsKey(key)) {
            out.replace(key, out.get(key)+(e_time-s_time));
        }
        else out.put(key, (e_time-s_time));

    }


    public static void main(String[] args) {

        int[] f= {180, 5000, 10, 600};
        String[] str = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(P92341.solution(f, str));
    }
}
