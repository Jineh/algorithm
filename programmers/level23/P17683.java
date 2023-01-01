
public class P17683 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m=change(m);
        String[] arr;
        int max=0;
        for(String str: musicinfos){
            arr= str.split(",");
            String melody = change(arr[3]);
            int play = calTime(arr[0], arr[1]);
            int time = melody.length();

            if(play <time){
                melody = melody.substring(0, play);
            }
            else if(play > time){
                StringBuilder sb = new StringBuilder();

                int a= play/time;
                int b=play%time;
                for(int i=0; i<a; i++){
                    sb.append(melody);
                }
                if(b!=0) sb.append(melody.substring(0, b));
                melody = sb.toString();
            }

            if(melody.contains(m) && melody.length()>max){
                answer = arr[2];
                max = melody.length();
            }
        }

        return answer;
    }

    static String change(String oldMelody){
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        return oldMelody.replaceAll("A#", "L");
    }

    static int calTime(String t1, String t2){
        int a1 = Integer.parseInt(t1.substring(0,2)) * 60 + Integer.parseInt(t1.substring(3));
        int a2 = Integer.parseInt(t2.substring(0,2)) * 60 + Integer.parseInt(t2.substring(3));
        return a2-a1;
    }

    public static void main(String[] args) {
        String a = "ABCDEFG";
        String[] b = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(P17683.solution(a, b));
    }
}
