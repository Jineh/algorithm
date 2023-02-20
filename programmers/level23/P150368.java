import java.util.Arrays;

public class P150368 {
    static int max_user=-1, max_money=-1;
    static int[][] arr;
    public static int[] solution(int[][] users, int[] emoticons) {
        arr = users;
        int[][] check = new int[emoticons.length][2];
        find(emoticons,0,check);
        int[] answer ={max_user, max_money};
        return answer;
    }


    static void find(int[] emoticons, int next, int[][] check){
        if(next == check.length-1){
            for(int i=40; i>=10; i-=10){
                check[next][0] = i;
                check[next][1] = emoticons[next] * (100-i)/100;
                cal(check);
            }
            return;
        }
        for(int i=40; i>=10; i-=10){
            check[next][0] = i;
            check[next][1] = emoticons[next] * (100-i)/100;
            find(emoticons, next+1, check);
        }
    }

    static void cal(int[][] check){
        int user=0, money=0;
        int[] res= new int[arr.length];
        for(int i=0; i<check.length; i++){
            int p = check[i][0];
            int m = check[i][1];
            for(int j=0; j<arr.length; j++){
                if(arr[j][0]<=p){
                    res[j]+=m;
                }
            }
        }

        for(int i=0; i<res.length; i++){
            if(arr[i][1]<=res[i]) user++;
            else money+=res[i];
        }

        if(user>max_user){
            max_user = user;
            max_money = money;
        }
        else if(user==max_user && money> max_money) max_money = money;

    }

    public static void main(String[] args) {
        int[][] a = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900},
                {40, 3100}, {27, 9200}, {32, 6900}};
        int[] b = {1300, 1500, 1600, 4900};
        System.out.println(Arrays.toString(P150368.solution(a, b)));
    }
}
