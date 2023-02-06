import java.util.*;

class S16245 {
    private final static int MAX_N = 1400;
    private final static int CMD_INIT = 1;
    private final static int CMD_ADD = 2;
    private final static int CMD_COST = 3;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(Scanner sc) {
        int q = sc.nextInt();

        int n;
        int[] sCityArr = new int[MAX_N];
        int[] eCityArr = new int[MAX_N];
        int[] mCostArr = new int[MAX_N];
        int sCity, eCity, mCost, mHub;
        int cmd, ans, ret = 0;
        boolean okay = false;

        for (int i = 0; i < q; ++i) {
            cmd = sc.nextInt();
            switch (cmd) {
                case CMD_INIT:
                    okay = true;
                    n = sc.nextInt();
                    for (int j = 0; j < n; ++j) {
                        sCityArr[j] = sc.nextInt();
                        eCityArr[j] = sc.nextInt();
                        mCostArr[j] = sc.nextInt();
                    }
                    ans = sc.nextInt();
                    ret = usersolution.init(n, sCityArr, eCityArr, mCostArr);
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_ADD:
                    sCity = sc.nextInt();
                    eCity = sc.nextInt();
                    mCost = sc.nextInt();
                    usersolution.add(sCity, eCity, mCost);
                    break;
                case CMD_COST:
                    mHub = sc.nextInt();
                    ans = sc.nextInt();
                    ret = usersolution.cost(mHub);
                    if (ret != ans)
                        okay = false;
                    break;
                default:
                    okay = false;
                    break;
            }
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        Scanner sc = new Scanner(System.in);

        TC = sc.nextInt();
        MARK = sc.nextInt();

        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(sc) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        sc.close();
    }

    static class UserSolution {
        HashMap <Integer,HashMap<Integer, Integer>> arr;
        HashMap <Integer,HashMap<Integer, Integer>> reverse;
        HashMap <Integer,HashMap<Integer, Integer>> dist;
        int[] node = new int[1401];
        int s, cost;

        public int init(int N, int sCity[], int eCity[], int mCost[]) {
            arr = new HashMap<>();
            reverse = new HashMap<>();
            dist = new HashMap<>();
            node = new int[1401];
            s=0;

            for(int i=0; i<N; i++){
                if(arr.containsKey(sCity[i])) arr.get(sCity[i]).put(eCity[i], mCost[i]);
                else {
                    arr.put(sCity[i], new HashMap<>());
                    arr.get(sCity[i]).put(eCity[i], mCost[i]);
                    node[s++] = sCity[i];
                }

                if(reverse.containsKey(eCity[i])) reverse.get(eCity[i]).put(sCity[i], mCost[i]);
                else {
                    reverse.put(eCity[i], new HashMap<>());
                    reverse.get(eCity[i]).put(sCity[i], mCost[i]);
                }
            }

            for(int i=0; i<s; i++){
                dist.put(node[i], new HashMap<>());
            }

            cost = s*100+1;
            return s;
        }

        public void add(int sCity, int eCity, int mCost) {
            arr.get(sCity).put(eCity, mCost);
            reverse.get(eCity).put(sCity, mCost);
            return;
        }

        public int cost(int mHub) {
            dijkstra(mHub, arr);
            int sum=0;
            for(int i=0; i<s; i++){
                sum+=dist.get(mHub).get(node[i]);
            }
            dijkstra(mHub, reverse);
            for(int i=0; i<s; i++){
                sum+=dist.get(mHub).get(node[i]);
            }
            return sum;
        }

        void dijkstra(int mHub, HashMap<Integer, HashMap<Integer, Integer>> arr){
            HashSet<Integer> set = new HashSet<>();
            set.add(mHub);

            for(int i=0; i<s; i++){
                if(mHub==node[i]) dist.get(mHub).put(node[i], 0);
                else dist.get(mHub).put(node[i], arr.get(mHub).getOrDefault(node[i], cost));
            }

            for(int i=0; i<s-1; i++){
                int cur = getMin(set, mHub);
                set.add(cur);

                for(int j=0; j<s; j++){
                    if(set.contains(node[j])) continue;
                    if(!arr.get(cur).containsKey(node[j]));
                    else if (dist.get(mHub).get(node[j]) >
                            dist.get(mHub).get(cur) + arr.get(cur).get(node[j])) {
                        dist.get(mHub).replace(node[j], dist.get(mHub).get(cur) + arr.get(cur).get(node[j]));
                    }
                }
            }
        }

        int getMin(HashSet<Integer> set, int mHub){
            int min =cost;
            int idx=-1;
            for(int i=0; i<s; i++){
                if(set.contains(node[i])) continue;
                    if (idx < 0 || dist.get(mHub).get(node[i]) < min) {
                        min = dist.get(mHub).get(node[i]);
                        idx = i;
                    }
            }
            return node[idx];
        }
    }
}