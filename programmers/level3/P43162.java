public class P43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(computers[i][j]==1){
                    check(i, j, parent);
                }
            }
        }

        for(int i=0; i<n; i++){
            if(parent[i]==i) answer++;
        }

        return answer;
    }

    public void check(int i, int j, int[] parent){
        int a = getParent(i, parent);
        int b =getParent(j, parent);

        if(a!=b) parent[a] = b;


    }

    public int getParent(int x, int[] parent){
        if(parent[x] == x) return x;
        return getParent(parent[x], parent);
    }
}
