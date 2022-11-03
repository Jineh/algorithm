public class P12911 {
    public int solution(int n) {
        int cntN = Integer.bitCount(n);
        int cntA=0;

        while(cntA != cntN){
            n++;
            cntA=Integer.bitCount(n);
        }
        return n;
    }
}
