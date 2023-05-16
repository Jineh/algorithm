public class P43163 {
    boolean[] visit;
    int min;
    public int solution(String begin, String target, String[] words) {
        min = words.length+1;
        visit = new boolean[words.length];
        dfs(begin,0, target, words);
        min = (min==words.length+1)? 0: min;
        return min;
    }

    public void dfs(String str, int cnt, String target, String[] words){
        if(str.equals(target)) {
            min = Math.min(cnt, min);
            return;
        }
        for(int i=0; i<words.length; i++){
            if(!visit[i]){
                if(wordCnt(str, words[i])){
                    visit[i] = true;
                    dfs(words[i], cnt+1, target, words);
                    visit[i] = false;
                }
            }
        }
    }

    public boolean wordCnt(String str, String str2){
        int cnt=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=str2.charAt(i)) cnt++;
            if(cnt>1) return false;
        }
        return true;
    }
}