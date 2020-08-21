import java.io.*;

public class Main {

    public static int DFS(int[] a, int[] c, int[] s, int v, int step) {
        int cnt = 1;

        while (true) {
            if (c[v] != 0) {
                if (s[v] != step) {
                    return 0;
                }
                return cnt - c[v];
            } // end if
            s[v] = step;
            c[v] = cnt;
            v = a[v];
            cnt = cnt + 1;
        } // end while
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n + 1];
            int[] c = new int[n + 1];
            int[] s = new int[n + 1];
            int ans = 0;

            String[] list = br.readLine().split(" ");
            for (int i = 1; i <= n; ++i) {
                int value = Integer.parseInt(list[i - 1]);
                a[i] = value;
            } // end for

            for (int i = 1; i <= n; ++i) {
                if (c[i] == 0) {
                    ans = ans + DFS(a, c, s, i, i);
                }
            } // end for
            bw.write(String.valueOf(n - ans) + "\n");
        } // end while
        bw.flush();
        bw.close();
        br.close();

    }
}
