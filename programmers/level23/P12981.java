import java.util.ArrayList;

public class P12981 {
    public static int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> arr = new ArrayList<>();
        arr.add(words[0]);

        for(int i=1; i<words.length; i++){
            char pre = words[i-1].charAt(words[i-1].length()-1);
            if(pre!=words[i].charAt(0) || arr.contains(words[i])){
                int person = (i%n)+1;
                int track = i/n+1;
                answer[0] = person;
                answer[1] = track;
                break;
            }
            arr.add(words[i]);
        }
        return answer;
    }



    public static void main(String[] args) {

        int n =3;
        String[] arr = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(P12981.solution(n, arr));
    }
}
