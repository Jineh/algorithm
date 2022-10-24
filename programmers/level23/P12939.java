import java.util.Arrays;
import java.util.StringTokenizer;

public class P12939 {
    public static String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int[] arr = new int[st.countTokens()];

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        answer=arr[0]+ " "+arr[arr.length-1];
        return answer;
    }


    public static void main(String[] args) {

        String s= "1 2 3 4";
        System.out.println(P12939.solution(s));
    }
}
