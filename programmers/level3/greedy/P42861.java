import java.util.Arrays;

public class P42861 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (a1, a2) -> (a1[2] - a2[2]));

        for(int i=0; i<costs.length; i++){
            int a = findParent(parent, costs[i][0]);
            int b = findParent(parent, costs[i][1]);

            if(a!=b) {
                union(parent, a, b);
                answer += costs[i][2];
            }
        }

        return answer;
    }

    public int findParent(int[] parent, int tmp){
        if(parent[tmp] == tmp) return tmp;
        return findParent(parent, parent[tmp]);
    }

    public void union(int[] parent, int ap, int bp){
        if(ap < bp) parent[bp] = ap;
        else parent[ap] = bp;
    }
}
