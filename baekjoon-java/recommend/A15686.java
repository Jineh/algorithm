package recommend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A15686 {
    static int n, m, ans;
    static int[][] map;
    static boolean[] open;
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> person = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) chicken.add(new int[]{i,j});
                else if(map[i][j]==1) person.add(new int[]{i,j});
            }
        }

        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        dfs(0,0);
        System.out.println(ans);
    }

    static void dfs(int s, int cnt){
        if(cnt==m){
            int res=0;

            for(int i=0; i<person.size(); i++){
                int temp = Integer.MAX_VALUE;

                for(int j=0; j<chicken.size(); j++){
                    if(open[j]){ //선택된 치킨집 중에 최소 거리 선택
                        int distance = Math.abs(person.get(i)[0] - chicken.get(j)[0])
                                + Math.abs(person.get(i)[1] - chicken.get(j)[1]);

                        temp = Math.min(temp, distance);
                    }
                }
                res+=temp;
            }
            ans = Math.min(ans, res); //도시의 치킨 거리 최솟값
            return;
        }

        for(int i=s; i<chicken.size(); i++){
            open[i] = true; //치킨집 선택
            dfs(i+1, cnt+1);
            open[i] = false;
        }
    }
}

