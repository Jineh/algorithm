import java.util.*;

public class P42746 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a1, String a2){
                return (a2+a1).compareTo(a1+a2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            sb.append(arr[i]);
        }
        if(sb.toString().charAt(0)=='0') return "0";
        return sb.toString();
    }
}
