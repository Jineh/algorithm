package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G20365 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> bList = new ArrayList<>();
        List<String> rList = new ArrayList<>();

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, "R");

        while(st.hasMoreTokens()){
            bList.add(st.nextToken());
        }

        st = new StringTokenizer(line, "B");

        while(st.hasMoreTokens()){
            rList.add(st.nextToken());
        }

       if(rList.size() >= bList.size()){
           System.out.println(bList.size()+1);
       }
       else{
           System.out.println(rList.size()+1);
       }

    }
}
