public class P12951 {
    public static String solution(String s) {
        String answer = "";
        String[] str = s.toLowerCase().split(""); // 한 글자씩 나눔

        boolean space = true;

        for(String tmp : str){
            answer += space ? tmp.toUpperCase() : tmp;
            space = tmp.equals(" ")? true : false; //마지막이면 true
        }
        return answer;
    }

    public static void main(String[] args) {

        String s= "3people  unFollowed me ";
        System.out.println(P12951.solution(s));
    }
}

