import java.util.ArrayList;
import java.util.HashMap;

public class P42888 {
    public static String[] solution(String[] record) {

        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            String[] tmp = record[i].split(" ");

            if(tmp[0].equals("Enter")){
                arr.add(tmp[1]+",님이 들어왔습니다.");
                map.put(tmp[1], tmp[2]);
            }
            else if(tmp[0].equals("Change")){
                map.put(tmp[1], tmp[2]);
            }
            else if(tmp[0].equals("Leave")){
                arr.add(tmp[1]+",님이 나갔습니다.");
            }
        }

        String[] answer = new String[arr.size()];
        for(int i=0; i<answer.length; i++) {
            String[] tmp = arr.get(i).split(",");
            answer[i] = map.get(tmp[0])+tmp[1];
        }


        return answer;
    }

    public static void main(String[] args) {

        String[] r = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(P42888.solution(r));
    }
}
