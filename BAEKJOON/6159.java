import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] list = br.readLine().split(" ");

        int arrSize     = Integer.parseInt(list[0]);
        int costumeSize = Integer.parseInt(list[1]);

        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int sum = 0, cnt = 0;
        int p1 = 0, p2 = arrSize - 1;

        while (p1 < p2) {
            int cow1 = arr[p1];
            int cow2 = arr[p2];

            if (cow1 + cow2 > costumeSize) {
                p2 = p2 - 1;
            } else {
                cnt = cnt + (p2 - p1);
                p1 = p1 + 1;
            }
        }
        System.out.println(cnt);
    }
}
