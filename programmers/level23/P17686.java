import java.util.Arrays;
import java.util.Comparator;

public class P17686 {
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = detach(o1);
                String[] file2 = detach(o2);

                int check = file1[0].compareTo(file2[0]);
                if(check==0){
                    return Integer.parseInt(file1[1])-Integer.parseInt(file2[1]);
                }
                else{
                    return check;
                }

            }

            public String[] detach(String str){
                String h="";
                String n="";
                String t="";

                int i=0;
                for(; i<str.length(); i++){
                    char c = str.charAt(i);
                    if(c>='0' && c<='9') break;
                    h+=c;
                }

                for(; i<str.length(); i++){
                    char c = str.charAt(i);
                    if(!(c>='0' && c<='9')) break;
                    n+=c;
                }

                t+=str.substring(i);

                String[] file = {h.toLowerCase(), n, t};
                return file;
            }
        });
        return files;
    }


    public static void main(String[] args) {

        String[] arr = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG",
                "img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
        System.out.println(P17686.solution(arr));
    }
}
