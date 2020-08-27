import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final int MAX = 1_000_000;
    public static int[] arr;

    public static void eratos() {
         arr = new int[MAX + 1];
         for (int i = 2; i <= MAX; ++i) {
             arr[i] = i;
         }
         int end = (int)Math.sqrt(MAX);
         for (int i = 2; i <= end; ++i) {
             if (arr[i] == 0) {
                 continue;
             }
             for (int j = i * i; j <= MAX; j = j + i) {
                 arr[j] = 0;
             }
         } // end for
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        eratos();

        int num = Integer.parseInt(br.readLine());

        for (int i = 2; i <= num; ++i) {
            if (arr[i] != 0) {
                Set<Integer> set = new HashSet<>();
                String s = String.valueOf(i);
                boolean flag = false;
                while (true) {
                    int sum = 0;
                    for (int j = 0; j < s.length(); ++j) {
                        sum = sum + (int)Math.pow(s.charAt(j) - '0', 2);
                    }
                    if (sum == 1) {
                        flag = true;
                        break;
                    }
                    if (!set.contains(sum)) {
                        set.add(sum);
                        s = String.valueOf(sum);
                    } else {
                        break;
                    }
                } // end while
                if (flag) {
                    bw.write(String.valueOf(i) + "\n");
                }
            } // end if
        } // end for
        bw.flush();
        bw.close();
        br.close();
    }
}
