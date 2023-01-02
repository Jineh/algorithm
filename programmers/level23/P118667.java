import java.util.LinkedList;
import java.util.Queue;

public class P118667 {
    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long a1 = sum(q1, queue1);
        long a2 = sum(q2, queue2);
        long sum = (a1+a2)/2;
        int p1 = 0, p2 = 0, limit = queue1.length*2;
        while(p1<=limit && p2<=limit){
            if(a1==sum) return p1+p2;
            else if(a1>sum){
                int tmp = q1.poll();
                q2.add(tmp);
                a1-=tmp;
                a2+=tmp;
                p1++;
            }
            else{
                int tmp = q2.poll();
                q1.add(tmp);
                a2-=tmp;
                a1+=tmp;
                p2++;
            }
        }

        return -1;
    }

    static long sum(Queue<Integer> arr, int[] q){
        long s=0;
        for(int a: q){
            arr.offer(a);
            s+=a;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2};
        int[] b = {1, 10, 1, 2};
        System.out.println(P118667.solution(a, b));
    }
}
