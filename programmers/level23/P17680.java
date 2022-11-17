import java.util.ArrayList;


public class P17680 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> arr = new ArrayList<>();

        if(cacheSize==0) return cities.length*5;

        for(int i=0; i<cities.length; i++){
            String str = cities[i].toLowerCase();
            if(arr.remove(str)) answer++;
            else{
                answer+=5;
                if(cacheSize<=arr.size()) arr.remove(0);
            }
            arr.add(str);
        }
        return answer;
    }


    public static void main(String[] args) {

        int n =1;
        String[] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(P17680.solution(n, arr));
    }
}
