import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[] visited;

    public static void init(BufferedReader br, int n) throws IOException {
        list = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; ++i) {
            list.add(new ArrayList<>());
        }

        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= n; ++i) {
            int v1 = i;
            int v2 = Integer.parseInt(line[i - 1]);

            list.get(v1).add(v2);
        }
    }

    public static void dfs(int i) {
        visited[i] = true;
        for (int vv : list.get(i)) {
            if (!visited[vv]) {
                dfs(vv);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            init(br, n);
            for (int i = 1; i <= n; ++i) {
                if (!visited[i]) {
                    cnt = cnt + 1;
                    dfs(i);
                }
            } // end for
            bw.write(String.valueOf(cnt) + "\n");

        } // end while
        bw.flush();
        bw.close();
        br.close();

    }
}
