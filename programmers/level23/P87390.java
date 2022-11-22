
public class P87390{
    public static int[] solution(int n, long left, long right) {

        int[] answer = new int[(int)right-(int)left +1];
        int cnt=0;
        while (left <= right) {
            answer[cnt] = (int)(Math.max(Math.floor(left / n), left++ % n) + 1);
            cnt++;
        }

        return answer;
    }


    public static void main(String[] args) {

        System.out.println(P87390.solution(3, 2, 5));
    }
}
