import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num == 0) {
            System.out.println(0);
            return;
        } else if (num == 1 || num == 2) {
            System.out.println(1);
            return;
        }

        BigInteger[] result = new BigInteger[num + 1];
        result[0] = BigInteger.valueOf(0);
        result[1] = BigInteger.valueOf(1);
        result[2] = BigInteger.valueOf(1);
        for (int i = 3; i <= num; ++i) {
            result[i] = result[i - 2].add(result[i - 1]);
        } // end for

        System.out.println(result[num]);
    }
}
