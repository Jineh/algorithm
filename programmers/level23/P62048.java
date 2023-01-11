public class P62048 {
    public static long solution(int w, int h) {
        long answer = 1;
        Long width = Long.valueOf(w);
        Long height = Long.valueOf(h);
        long g = find(width, height);

        answer = width*height - (width + height - g);
        return answer;
    }


    static long find(long w, long h){
        if(w<h){
            long t = w;
            w = h;
            h = t;
        }

        while(h>0){
            long tmp = w%h;
            w=h;
            h=tmp;
        }

        return w;
    }

    public static void main(String args[]) throws Exception{
        System.out.println(P62048.solution(8, 12));

    }
}
