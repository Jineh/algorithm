import java.util.Scanner;

public class Java010 {
    public static void main(String[] args) {
        int n =3;
        char x ='n';
        float y = 0.1f;

//        Scanner sc = new Scanner(System.in);
//        String num = sc.nextLine();
//
//        String [] str = num.split(" ");
//        int a = Integer.parseInt(str[0]);
//        int b = Integer.parseInt(str[1]);
//
//        System.out.println(a+" "+b);

        Scanner sc = new Scanner(System.in);
 //       String str = sc.nextLine();
 //       char [] chars = str.toCharArray();
 //       System.out.println(chars[2]+ " "+chars[0]);

//        float f = sc.nextFloat();

//        String str = String.format("%.2f", f);
//        System.out.println(str);

        String date = sc.nextLine();
        String [] arr = date.split("[.]");
        //마침표(.)를 범위를 나타내는 [] 사이에 넣어서, 문자로 취급
        String year = String.format("%04d", Integer.parseInt(arr[0]));
        String month = String.format("%2d", Integer.parseInt(arr[1]));
        String day = String.format("%02d", Integer.parseInt(arr[2]));

        System.out.println(year+"."+month+"."+day);
    }
}
