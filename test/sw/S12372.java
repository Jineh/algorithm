import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S12372 {

    private final static int MAX_INPUT = 100000;
    private final static int MAX_NUM = 30000;

    private final static UserSolution usersolution = new UserSolution();

    private static BufferedReader br;

    private static int[] input = new int[MAX_INPUT];
    private static long seed = 13410;

    private static long pseudoRand() {
        seed = (seed * 214013 + 2531011) & 0xffffffffL;
        return (seed>>11) % MAX_NUM;
    }

    private static void makeInput(int inputLen) {
        for(int i = 0; i < inputLen; i++) {
            input[i] = (int)(pseudoRand());
        }
    }

    private static int run() throws Exception {
        int score = 100;
        int N, userNum, uID = 0,sum, ret, ans;
        int[] result = new int[10];
        String str;

        str = br.readLine();
        N = Integer.parseInt(str);

        for(int i = 0; i < N; i++) {
            str = br.readLine();
            userNum = Integer.parseInt(str);
            makeInput(userNum);

            for(int j = 0; j < userNum; j++) {
                usersolution.addUser(uID++, input[j]);
            }
            ret = usersolution.getTop10(result);

            sum = 0;
            for(int j = 0; j < ret; j++) {
                sum += result[j];
            }
            str = br.readLine();
            ans = Integer.parseInt(str);
            if(sum != ans) {
                score = 0;
            }
        }
        return score;
    }
    public static void main(String[] args) throws Exception {
        int TC;
        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TC = Integer.parseInt(str);

        for (int tc = 1; tc <= TC; tc++) {
            usersolution.init();
            System.out.println("#" + tc + " " + run());
        }
    }


    static class UserSolution {
        int MAX_LEN = 100005;
        int[][] user;
        int size;

        public void init() {
            size=0;
             user = new int[MAX_LEN][2];
        }

        public void addUser(int uID, int income) {
            user[++size][0] = uID;
            user[size][1] = income;

            for(int i=size; (i>>1)!=0 && user[i>>1][1] <= user[i][1]; i>>=1){
                if(user[i>>1][1] == user[i][1] ){
                    if(user[i>>1][0] > user[i][0]) {
                        int a = user[i][0];
                        user[i][0] = user[i >> 1][0];
                        user[i >> 1][0] = a;
                    }
                }
                else {
                    int a = user[i >> 1][0];
                    int b = user[i >> 1][1];
                    user[i >> 1][0] = user[i][0];
                    user[i >> 1][1] = user[i][1];
                    user[i][0] = a;
                    user[i][1] = b;
                }
            }
        }

        int pop(int [][] copy, int cnt){
            int uid = user[1][0];
            copy[cnt][0] = user[1][0];
            copy[cnt][1] = user[1][1];
            user[1][0] = user[size][0];
            user[1][1] = user[size--][1];

            for(int i=1; (i<<1)<=size;){
                if((i<<1)==size || user[i<<1][1]>user[i<<1|1][1] ||
                        (user[i<<1][1] == user[i<<1|1][1]&& user[i<<1][0]<user[i<<1|1][0])){
                    if(user[i][1]<user[i<<1][1]){
                        int a = user[i << 1][0];
                        int b = user[i << 1][1];
                        user[i << 1][0] = user[i][0];
                        user[i << 1][1] = user[i][1];
                        user[i][0] = a;
                        user[i][1] = b;
                        i=i<<1;
                    }
                    else if(user[i][1]==user[i<<1][1] ){
                        if(user[i][0]>user[i<<1][0]) {
                            int a = user[i][0];
                            user[i][0] = user[i << 1][0];
                            user[i << 1][0] = a;
                        }
                        i=i<<1;
                    }
                    else break;
                }
                else{
                    if(user[i][1]<user[i<<1|1][1]) {
                        int a = user[i << 1 | 1][0];
                        int b = user[i << 1 | 1][1];
                        user[i << 1 | 1][0] = user[i][0];
                        user[i << 1 | 1][1] = user[i][1];
                        user[i][0] = a;
                        user[i][1] = b;
                        i=i<<1|1;
                    }
                    else if(user[i][1]==user[i<<1|1][1] ){
                        if(user[i][0]>user[i<<1|1][0]){
                        int a = user[i][0];
                        user[i][0] = user[i<<1|1][0];
                        user[i<<1|1][0] = a;
                        }
                        i=i<<1|1;
                    }
                    else break;
                }
            }
            return uid;
        }

        int getTop10(int[] result) {
            int res =0;
            int[][] copy= new int[10][2];
            int len =size;
            for(int i=0; i<len; i++){
                if(res==10) break;
                result[i]= pop(copy, i);
                res++;
            }

            for(int i=0; i<res; i++){
                addUser(copy[i][0], copy[i][1]);
            }

            return res;
        }
    }
}
