public class P12979 {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left=1;

        for(int next: stations){
            if(left <next-w){
                int end = next-w;
                int length = end - left;
                int cnt = length / (w*2+1);
                if(length % (w*2+1)!=0) cnt++;
                answer+=cnt;
            }
            left = next +w+1;
        }

        if(stations[stations.length-1] + w +1<=n){
            left = stations[stations.length-1] + w +1;
            int end = n+1;
            int length = end-left;
            int cnt = length / (w*2+1);
            if(length % (w*2+1)!=0) cnt++;
            answer+=cnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {4, 11};
        System.out.println(P12979.solution(11, a, 1));
    }
}
