import java.util.ArrayList;

public class P17677 {
    public static int solution(String str1, String str2) {
        double min=0, max=0;

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<str1.length()-1; i++){
            String s = str1.substring(i,i+2).toLowerCase();
            if(s.matches("^[a-zA-Z]*$")) arr.add(s);
        }
        max = arr.size();

        for(int i=0; i<str2.length()-1; i++){
            String s = str2.substring(i,i+2).toLowerCase();
            if(s.matches("^[a-zA-Z]*$")){
                if(arr.contains(s)) {
                    min++;
                    arr.remove(s);
                }
                else max++;
            }
        }

        if(max==0 && min==0) return 65536;
        double a = min/max *65536;

        return (int)a;
    }

    public static void main(String[] args) {

        System.out.println(P17677.solution("FRANCE", "french"));
    }
}
