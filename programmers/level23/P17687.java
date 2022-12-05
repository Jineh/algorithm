public class P17687 {
    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int i=0, k=0;
        while(t>0){
            String str = Integer.toString(i++,n);
            int len = str.length();
            while(len-->0){
                k%=m;
                k++;
                if(t==0) return answer.toString().toUpperCase();
                if(k==p) {
                    answer.append(str.charAt(0));
                    t--;
                }
                str = str.substring(1);
            }
        }
        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {

        System.out.println(P17687.solution(16, 16, 2, 2));
    }
}
