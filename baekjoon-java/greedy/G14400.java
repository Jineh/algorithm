package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G14400 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int [][] loc = new int[n][2];
        int x =0, y=0;
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            loc[i][0] = Integer.parseInt(st.nextToken());
            loc[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(loc, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        x = loc[n/2][0]; //짝수면 뒤의 값이 되어야 그 뒤의 값들의 거리가 짧아짐

        Arrays.sort(loc, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[1], o2[1]);
            }
        });

        y = loc[n/2][1];

        long sum =0;
        for(int[] l: loc){
            sum+= Math.abs(x-l[0]) + Math.abs(y-l[1]);
        }

        System.out.println(sum);
    }
}
