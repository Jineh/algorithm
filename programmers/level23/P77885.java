public class P77885 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i< numbers.length; i++){
            if(numbers[i]%2==0) answer[i] = ++numbers[i];
            else{
                StringBuilder tmp = new StringBuilder();
                String binary = Long.toBinaryString(numbers[i]);

                if(!binary.contains("0")){
                    tmp.append("10");
                    tmp.append(binary.substring(1));
                }
                else{
                    int lastIndex = binary.lastIndexOf("0");
                    int firstOneIndex = binary.indexOf("1",lastIndex);
                    tmp.append(binary,0,lastIndex).append("1");
                    tmp.append("0");
                    tmp.append(binary.substring(firstOneIndex+1));
                }
                answer[i] = Long.parseLong(tmp.toString(),2);
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        long[] l = {2, 7};
        System.out.println(P77885.solution(l));
    }
}
