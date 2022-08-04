package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] loc = new int[n][2];
        int cnt=0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            loc[i][0] = Integer.parseInt(st.nextToken());
            loc[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(loc, new Comparator<int[]>(){
           public int compare(int [] a1, int[] a2){
               if(a1[0] == a2[0]) return a1[1] - a2[1];
               return a1[0] -a2[0];
           }
        });

        int range=0;
        for(int i=0; i<n; i++){
            if(loc[i][0] > range) range = loc[i][0];
            if(loc[i][1] > range){
                while(loc[i][1] > range){
                    range+=l;
                    cnt++;
                }
            }

        }

        System.out.println(cnt);
    }
}
