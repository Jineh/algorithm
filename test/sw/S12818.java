import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S12818 {
    static long ans;
    static int [] buf;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int cnt = 0;

        while (T-- > 0) {
            ans= 0;
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int []arr = new int[n];
            buf = new int[arr.length];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            mergeSort(arr, 0,n);

            System.out.println("#" + ++cnt + " " + ans);
        }
    }

    static void mergeSort(int arr[], int begin, int end){
        if(end-begin <=1) return;
        int mid= begin + (end - begin)/2;
        mergeSort(arr, begin, mid);
        mergeSort(arr,mid, end);

        int i=begin, j=mid, k=begin;
        while(i!=mid && j!=end) {
            if (arr[i] > arr[j]) {
                ans+=mid-i;
                buf[k++] = arr[j++];
            } else {
                buf[k++] = arr[i++];
            }
        }
        while(j!=end) buf[k++] = arr[j++];
        while(i!=mid) buf[k++] = arr[i++];

        for(i=begin; i<end; i++) arr[i] = buf[i];
    }
}