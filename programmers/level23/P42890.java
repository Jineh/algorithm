import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class P42890 {
    public static boolean[] check;
    public static List<String> key = new LinkedList<String>();
    public static int solution(String[][] relation) {
         check = new boolean[relation[0].length];
        for (int i = 1; i <= relation[0].length; i++) {
            comb(0, relation[0].length, i, relation);
        }
        return key.size();
    }

    public static void comb(int start, int n, int step, String[][] relation) {
        if (step == 0) {
            strCheck(n, relation);
            return;
        }
        for (int i = start; i < n; i++) {
            check[i] = true;
            comb(i+1, n, step - 1, relation);
            check[i] = false;
        }

    }

    public static void strCheck(int n, String[][] relation) {
        StringBuilder col= new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (check[i]) col.append(i);
        }

            for (String sub : key) {
                int count = 0;
                for (int i = 0; i < sub.split("").length; i++) {
                    if(col.toString().contains(String.valueOf(sub.charAt(i))))
                        count++;
                }

                if (sub.length() == count) // 부분집합은 가능
                    return;
            }

            HashSet<String> set = new HashSet<String>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < relation[0].length; j++) {
                    if (check[j]) str.append(relation[i][j]);
                }
                if (!set.add(str.toString())) return;
            }
            key.add(col.toString());
    }


    public static void main(String[] args) {
        String[][] a = {{"100","ryan","music","2"}, {"200","apeach","math","2"},
                {"300","tube","computer","3"}, {"400","con","computer","4"},
                {"500","muzi","music","3"}, {"600","apeach","music","2"}};
        System.out.println(P42890.solution(a));
    }
}
