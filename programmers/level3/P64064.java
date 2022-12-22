import java.util.HashSet;
import java.util.LinkedHashSet;

public class P64064 {
    static HashSet<HashSet<String>> answer;
    public static int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet();
        dfs(new LinkedHashSet<>(), user_id, banned_id);
        return answer.size();
    }

    static void dfs(HashSet<String> h, String[] user_id, String[] banned_id){
        if(h.size()== banned_id.length){
            if(check(h, banned_id)){
                answer.add(new HashSet<>(h));
            }
            return;
        }

        for(String userId : user_id){
            if(h.add(userId)) {
                dfs(h, user_id, banned_id);
                h.remove(userId);
            }
        }

    }

    static boolean check(HashSet<String> h, String[] banned_id){
        int idx =0;
        for(String id: h){
            String banId = banned_id[idx++];
            if(id.length() != banId.length()) return false;
            for(int i=0; i<banId.length(); i++){
                if(banId.charAt(i)=='*') continue;
                if(id.charAt(i)!=banId.charAt(i)) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] a = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] b = {"fr*d*", "abc1**"};
        System.out.println(P64064.solution(a,b));
    }

}
