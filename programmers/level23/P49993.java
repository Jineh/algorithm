import java.util.ArrayList;

public class P49993 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Character> arr = new ArrayList<>();
        for(int i=0; i<skill.length(); i++){
            arr.add(skill.charAt(i));
        }

        for(String str : skill_trees){
            String mySkill = skill;
            boolean check =true;

            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(arr.contains(c)){
                    if(mySkill.charAt(0)==c) mySkill = mySkill.substring(1);
                    else {
                        check=false;
                        break;
                    }
                }
            }
            if(check) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] a = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(P49993.solution("CBD", a));
    }
}
