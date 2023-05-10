public class P84512 {
    public int solution(String word) {
        int answer = word.length(); //index 0부터 시작, AAAAA면 0이다
        String str = "AEIOU";
        int[] cal = {781, 156, 31, 6, 1};


        for(int i=0; i<word.length(); i++){
            int idx = str.indexOf(word.charAt(i));
            answer+= cal[i] * idx;
        }

        return answer;
    }
}
