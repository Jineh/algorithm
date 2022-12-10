public class P49994 {
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][] check = new boolean[11][11][4];
        int x=5, y=5, d=0, r=0;
        int nx=5, ny=5;

        for(int i=0; i<dirs.length(); i++){
            char tmp = dirs.charAt(i);

            if(x>0 && tmp=='L') {
                x-=1;
                d=0;
                r=1;
            }
            else if(x<10 && tmp=='R') {
                x+=1;
                d=1;
                r=0;
            }
            else if(y>0 && tmp=='U') {
                y-=1;
                d=2;
                r=3;
            }
            else if(y<10 && tmp=='D') {
                d=3;
                y+=1;
                r=2;
            }
            if(!check[y][x][d]){
                check[y][x][d]=true;
                check[ny][nx][r]=true;
                answer++;
            }

            ny=y;
            nx=x;

        }

        return answer;
    }

    public static void main(String[] args) {

        String str = "UDU";
        System.out.println(P49994.solution(str));
    }
}
