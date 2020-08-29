import java.io.*;
import java.util.Arrays;

public class Main {
    public static int[] initArr(BufferedReader br, int arrSize) throws IOException {
        int[] arr = new int[arrSize + 1];
        arr[0] = 0;
        String[] list = br.readLine().split(" ");
        for (int i = 1; i <= arrSize; ++i) {
            arr[i] = arr[i - 1] + Integer.parseInt(list[i - 1]);
        }
        return arr;
    }
    public static int getMaximumSubArr(int[] arr) {
        int maxValue = -Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                maxValue = Math.max(maxValue, arr[j] - arr[i - 1]);
            }
        }
        return maxValue;
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int testCase = Integer.parseInt(br.readLine());

       for (int i = 0; i < testCase; ++i) {
           int arrSize = Integer.parseInt(br.readLine());
           int[] arr = initArr(br, arrSize);
           int result = getMaximumSubArr(arr);
           bw.write(result + "\n");
       } // end while

       bw.flush();
       bw.close();
       br.close();
    }
}
