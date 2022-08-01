package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class G1449 {
    static int n;
    static int l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> loc = new ArrayList<Integer>(n);
        for(int i=0; i<n; i++){
            loc.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(loc);
        solution(loc);

    }

    static void solution(ArrayList<Integer> loc){
        int range = (int)(loc.get(0) -0.5 + l);
        int res=1;

        for(int i=1; i<n; i++){
            if(range < (int)(loc.get(i) + 0.5)){
                range = (int)(loc.get(i) - 0.5 +l);
                res++;
            }
        }
        System.out.println(res);

    }


}
