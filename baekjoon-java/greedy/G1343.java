package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G1343 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        String a ="AAAA";
        String b ="BB";

        board = board.replaceAll("XXXX", a);
        board = board.replaceAll("XX", b);

        if(board.contains("X")){
            board = "-1";
        }

        System.out.println(board);

    }
}
