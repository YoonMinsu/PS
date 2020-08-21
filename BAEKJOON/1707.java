import java.io.*;
import java.util.*;

public class Main {
    static boolean flag;

    public static void DFS(ArrayList<ArrayList<Integer>> list, int[] colors, int v, int color ) {
        colors[v] = color;

        for (int vv : list.get(v)) {
            if (colors[vv] == color) {
                flag = false;
                return;
            }

            if (colors[vv] == 0) {
                DFS(list, colors, vv, color * -1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> list;

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String[] line = br.readLine().split(" ");
            int v = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);

            int[] colors = new int[v + 1];
            flag = true;
            list = new ArrayList<>();
            for (int i = 0; i <= v; ++i) {
                list.add(new ArrayList<>());
                colors[i] = 0;
            }

            while (e-- > 0) {
                line = br.readLine().split(" ");
                int v1 = Integer.parseInt(line[0]);
                int v2 = Integer.parseInt(line[1]);

                list.get(v1).add(v2);
                list.get(v2).add(v1);
            } // end while

            for (int i = 1; i <= v; ++i) {
                if (!flag) {
                    break;
                }

                if (colors[i] == 0) {
                    DFS(list, colors, i, 1);
                }
            } // end for
            if (!flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        } // end while

    }
}
