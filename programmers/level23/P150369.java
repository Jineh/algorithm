public class P150369 {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int tmp = n - 1;
        int mcap, i;
        while (tmp >= 0) {
            if (deliveries[tmp] == 0 && pickups[tmp] == 0) {
                tmp--;
                continue;
            }
            mcap = cap;
            i = tmp;
            while (i >= 0) {
                if (mcap == deliveries[i]) {
                    deliveries[i] = 0;
                    break;
                } else if (mcap < deliveries[i]) {
                    deliveries[i] = deliveries[i] - mcap;
                    break;
                }
                mcap -= deliveries[i];
                deliveries[i] = 0;
                i--;
            }

            mcap = cap;
            i = tmp;
            while (i >= 0) {
                if (mcap == pickups[i]) {
                    pickups[i] = 0;
                    break;
                } else if (mcap < pickups[i]) {
                    pickups[i] = pickups[i] - mcap;
                    break;
                }
                mcap -= pickups[i];
                pickups[i] = 0;
                i--;
            }

            answer += ((tmp+1)*2);
        }
        return answer;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 7;
        int[] a = {1, 0, 2, 0, 1, 0, 2};
        int[] b = {0, 2, 0, 1, 0, 2, 0};
        System.out.println(P150369.solution(x, y, a, b));
    }
}
