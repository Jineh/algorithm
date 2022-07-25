package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class G1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        for(int i =0; i<n; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        for(int i =0; i<m; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());


        if(box.get(0)>crane.get(0)){
            System.out.println(-1);
            return;
        }

        int count =0;
        while(!box.isEmpty()){
            int index=0;
            for(int i =0; i<crane.size();){
                if(index == box.size()) break;
                else if(crane.get(i) >= box.get(index)){ //크레인에 담으면 다음 크레인
                    box.remove(index);
                    i++;
                }
                else { // 다음 크레인으로 이동 못 하면 처음으로 가야 함
                    index++;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
