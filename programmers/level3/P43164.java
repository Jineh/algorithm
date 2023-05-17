public class P43164 {
    boolean[] visit;
    String[] load;
    public String[] solution(String[][] tickets) {
        load = new String[tickets.length+1];
        load[0] = "";
        visit = new boolean[tickets.length];
        String[] tmp = new String[tickets.length+1];

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                visit[i] = true;
                tmp[0] = "ICN";
                dfs(tickets[i][1], tickets, 1, tmp);
                visit[i] = false;
            }
        }
        return load;
    }

    public void dfs(String str, String[][] tickets, int cnt, String[] tmp){
        if(cnt==tickets.length){
            tmp[cnt] = str;
            check(tmp);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(!visit[i]){
                if(tickets[i][0].equals(str)){
                    visit[i] = true;
                    tmp[cnt] = str;
                    dfs(tickets[i][1], tickets, cnt+1, tmp);
                    visit[i] = false;
                }
            }
        }
    }

    public void check(String[] tmp){
        if(load[0].equals("")) {
            load = tmp.clone();
            return;
        }
        for(int i=0; i<tmp.length; i++){
            if(tmp[i].compareTo(load[i])<0){
                load = tmp.clone();
                break;
            }
            else if(tmp[i].compareTo(load[i])>0){
                break;
            }
        }
    }
}
