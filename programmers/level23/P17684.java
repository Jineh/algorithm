import java.util.ArrayList;
import java.util.HashMap;

public class P17684 {
    public static ArrayList solution(String msg) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        msg = msg.toUpperCase();
        int i=27, j;
        while(!msg.equals("")){
            j=2;
            String str = (msg.length()>=2) ? msg.substring(0, j) : msg;
            if(map.containsKey(str)){
                if(msg.length()>=3){
                    while(msg.length()>=j+1 && map.containsKey(str)){
                        str = msg.substring(0, ++j);
                    }
                    if(!map.containsKey(str)){
                        map.put(str, i++);
                        str = msg.substring(0, --j);
                    }
                }
                arr.add(map.get(str));
                msg = msg.substring(j);
            }
            else {
                arr.add(str.charAt(0)-64);
                msg = msg.substring(1);
                map.put(str, i++);
            }

        }

        return arr;
    }


    public static void main(String[] args) {

        System.out.println(P17684.solution("ABABABABABABABAB"));
    }
}
