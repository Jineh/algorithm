import java.util.Arrays;

public class P42747 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i=0; i<citations.length; i++) {
            int hIndex = citations.length-i;
            if (citations[i] >= hIndex) {
                answer = hIndex; //인용 횟수가 아닌 n편을 저장
                break;
            }
        }
        return answer;
    }
}
