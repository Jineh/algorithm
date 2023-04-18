import java.util.ArrayList;

public class P60057 {
    public static int solution(String s) {
        int len = s.length()/2;
        String[] arr = s.split("");
        int min = s.length();
        while(len>0){
            int cur = find(arr, len);
            if(cur<min) min = cur;
            len--;
        }
        return min;
    }

    public static int find(String[] arr, int len){
        StringBuilder str;
        ArrayList<String> splits = new ArrayList<String>();
        int cnt=1, cur=0;
        for(int i=0; i<arr.length; i+=len){
            str = new StringBuilder();
            for(int j=i; j<len+i; j++){
                if(j==arr.length) break;
                str.append(arr[j]);
            }
            splits.add(str.toString());
            if(i==0) cur+=len;
            else if(splits.get(splits.size()-2).equals(splits.get(splits.size()-1))){
                cnt++;
            }
            else{
                if (cnt > 1 && cnt < 10) cur++;
                else if (cnt >= 10 && cnt < 100) cur += 2;
                else if (cnt >= 100 && cnt < 1000) cur += 3;
                cur+=splits.get(splits.size()-1).length();
                cnt=1;
            }
        }
        if(cnt>1&&cnt<10) cur++;
        else if(cnt>=10&& cnt<100) cur+=2;
        else if(cnt>=100&& cnt<1000) cur+=3;
        return cur;
    }
    public static void main(String[] args) {

        System.out.println(P60057.solution("aaaaaaaaaa"));
    }
}
