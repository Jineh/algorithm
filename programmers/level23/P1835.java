public class P1835 {
        public static int answer=0;
        public static String[] member ={"A", "C", "F", "J", "M", "N", "R", "T"};
        public static int solution(int n, String[] data) {
            boolean[] visit = new boolean[member.length];
            dfs("", data, visit);
            return answer;
        }

        public static void dfs(String str, String[] data, boolean[] visit){
            if(str.length()==7){ //마지막 자리는 안 정해도 자동으로 정해진다.
                if(check(str, data)) answer++;
                return;
            }
            for(int i=0; i<member.length; i++){
                if(!visit[i]){
                    visit[i] = true;
                    String s = str + member[i];
                    dfs(s, data, visit);
                    visit[i] = false;
                }
            }

        }

        public static boolean check(String str, String[] data){
            for(String s: data){
                int one = str.indexOf(s.charAt(0));
                int two = str.indexOf(s.charAt(2));
                int num = s.charAt(4) -'0';
                char c = s.charAt(3);
                if(c=='='){
                    if(Math.abs(one-two)!=num+1) return false;
                }
                else if(c=='>'){
                    if(Math.abs(one-two)<=num+1) return false;
                }
                else{
                    if(Math.abs(one-two)>=num+1) return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        String[] a = {"N~F=0", "R~T>2"};
        System.out.println(P1835.solution(2, a));
    }
}
