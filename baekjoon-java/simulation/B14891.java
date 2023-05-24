package simulation;
import java.util.*;
import java.io.*;

public class B14891 {
    static ArrayList<Character>[] top;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        top = new ArrayList[4];

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            top[i] = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                top[i].add(str.charAt(j));
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[][] rot = new int[k][2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rot[i][0] = Integer.parseInt(st.nextToken());
            rot[i][1] = Integer.parseInt(st.nextToken());
        }

        int res = find(rot);
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    public static int find(int[][] rot) {
        for (int i = 0; i < rot.length; i++) {
            int num = rot[i][0] - 1;
            int dx = rot[i][1];
            visit = new boolean[4];
            visit[num] = true;

            if (num == 0) {
                if (top[num].get(2) != top[num + 1].get(6)) dfs(dx, false, num);
            } else if (num == 3) {
                if (top[num].get(6) != top[num - 1].get(2)) dfs(dx, true, num);
            } else {
                if (top[num].get(6) != top[num - 1].get(2)) dfs(dx, true, num);
                if (top[num].get(2) != top[num + 1].get(6)) dfs(dx, false, num);
            }
            visit[num] = false;
            rotation(dx, num);
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            if (top[i].get(0) == '1') res += Math.pow(2, i);
        }
        return res;
    }

    public static void dfs(int dx, boolean left, int cur) {
        int nx = (dx == 1) ? -1 : 1;
        if (left && cur != 0) {
            if (top[cur].get(6) != top[cur - 1].get(2)) {
                dfs(nx, true, cur - 1);
            }
        } else if (!left && cur != 3) {
            if (top[cur].get(2) != top[cur + 1].get(6)) {
                dfs(nx, false, cur + 1);
            }
        }
        rotation(dx, cur);
    }

    public static void rotation(int dx, int cur){
        if(visit[cur]) return;
        if (dx == 1) {
            Character last = top[cur].remove(7);
            top[cur].add(0, last);
        } else if (dx == -1) {
            Character first = top[cur].remove(0);
            top[cur].add(first);
        }
        visit[cur] = true;
    }
}
