package simulation;

import java.io.*;
import java.util.StringTokenizer;

public class B2578 {
    static int[] ver= new int[5];
    static int[] hor= new int[5];
    static int cro1=0, cro2=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] bingo= new int[5][5];
        int[][] arr = new int[5][5];
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = findBingo(bingo, arr);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    public static int findBingo(int[][] bingo, int[][] arr){
        int cnt=0, res=0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                cnt+=findNum(bingo, arr[i][j]);
                if(cnt>=3) {
                    res = (i * 5) + j + 1;
                    return res;
                }
            }
        }
        return res;
    }


    public static int findNum(int[][] bingo, int num){
        int res=0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(bingo[i][j]==num){
                    if(i==j) if(++cro1==5) res++;
                    if (i+j==4) if(++cro2==5) res++;
                    if(++hor[j]==5) res++;
                    if(++ver[i]==5) res++;
                    return res;
                }
            }
        }
        return res;
    }
}
