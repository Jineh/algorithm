package simulation;

import java.io.*;
import java.util.*;

public class B21608{
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] tmpLoc;
    static int n;
    static Map<Integer, Set<Integer>> likeSt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int stNum;

        tmpLoc = new int[n+1][n+1]; //현재 위치
        likeSt = new HashMap<>();

        for(int i=1; i<=n*n; i++){
            st = new StringTokenizer(br.readLine());
            stNum = Integer.parseInt(st.nextToken());
            likeSt.put(stNum, new HashSet<>());

            for(int j=0; j<4; j++){
                likeSt.get(stNum).add(Integer.parseInt(st.nextToken()));
            }

            Student student = solve(stNum);
            tmpLoc[student.x][student.y] = stNum;
        }

        int res = calLike();

        bw.write(String.valueOf(res));
        bw.close();
        br.close();
    }

    public static int calLike(){
        int sum=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int cnt = findCloseSt(i, j, tmpLoc[i][j]);
                if(cnt>0) sum+= Math.pow(10, cnt-1);
            }
        }
        return sum;
    }

    public static Student solve(int stNum){
        Student res  = null;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(tmpLoc[i][j]>0) continue;

                Student tmp = new Student(i, j, findCloseSt(i, j, stNum), findEmptySt(i, j));

                if(res == null){
                    res = tmp;
                    continue;
                }

                if(res.compareTo(tmp) > 0) res = tmp;
            }
        }
        return res;
    }

    public static int findCloseSt(int x, int y, int stNum){
        int cnt=0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<1 || ny<1 || nx>n || ny>n) continue;

            if(likeSt.get(stNum).contains(tmpLoc[nx][ny])) cnt++;
        }
        return cnt;
    }

    public static int findEmptySt(int x, int y){
        int cnt=0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<1 || ny<1 || nx>n || ny>n) continue;

            if(tmpLoc[nx][ny]==0) cnt++;
        }
        return cnt;
    }


    static class Student implements Comparable<Student> {
        int x;
        int y;
        int closeCnt;
        int emptyCnt;

        public Student(int x, int y, int closeCnt, int emptyCnt){
            this.x = x;
            this.y = y;
            this.closeCnt = closeCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Student s){
            if(closeCnt != s.closeCnt)
                return -(closeCnt - s.closeCnt);

            if(emptyCnt != s.emptyCnt)
                return -(emptyCnt - s.emptyCnt);

            if(x != s.x)
                return x-s.x;

            return y-s.y;
        }
    }
}
