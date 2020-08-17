import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

class BaekJoon_11652 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        long[] nums = new long[num];
        for (int i = 0; i < num; ++i) {
            nums[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(nums);

        int cnt = 1, max = 1;
        long answer = nums[0];

        for (int i = 1; i < num; ++i) {
            if (nums[i] == nums[i-1]) {
                cnt = cnt + 1;
            } else {
                cnt = 1;
            }

            if (cnt > max) {
                max = cnt;
                answer = nums[i];
            }
        }

        System.out.println(answer);

    }

    public void run() throws IOException {
        solution();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_11652().run();
    }
}
