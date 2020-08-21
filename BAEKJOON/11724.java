import java.io.*;
import java.util.*;

public class Main {

    public static void dfs(ArrayList<ArrayList<Integer>> lists, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int v : lists.get(vertex)) {
            if (!visited[v]) {
                dfs(lists, visited, v);
            }
        } // end for
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        boolean[] visited = new boolean[n + 1];

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            lists.add(new ArrayList<>());
        } // end for

        for (int i = 0; i < m; ++i) {
            line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            lists.get(v1).add(v2);
            lists.get(v2).add(v1);
        } // end for

        int graphCnt = 0;
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                graphCnt = graphCnt + 1;
                dfs(lists, visited, i);
            }
        } // end for

        System.out.println(graphCnt);
    }
}
