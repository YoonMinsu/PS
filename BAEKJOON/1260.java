import java.io.*;
import java.util.*;

public class Main {
    public static void DFS(BufferedWriter bw, ArrayList<ArrayList<Integer>> list, boolean[] visited, int index) throws IOException {
        visited[index] = true;
        bw.write(String.valueOf(index) + " ");
        for (int value : list.get(index)) {
            if (!visited[value]) {
                DFS(bw, list, visited, value);
            }
        } // end for
    }

    public static void BFS(BufferedWriter bw, ArrayList<ArrayList<Integer>> list, boolean[] visited, int index) throws IOException {
        Queue<Integer> q = new LinkedList<>();

        q.offer(index);
        visited[index] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            bw.write(String.valueOf(v) + " ");
            for (int value : list.get(v)) {
                if (!visited[value]) {
                    q.offer(value);
                    visited[value] = true;
                }
            } // end for
        } // end while
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] list = br.readLine().split(" ");

        int n = Integer.parseInt(list[0]);
        int m = Integer.parseInt(list[1]);
        int v = Integer.parseInt(list[2]);

        boolean[] visited = new boolean[n + 1];

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            String[] line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);

            lists.get(v1).add(v2);
            lists.get(v2).add(v1);
        } // end

        for (int i = 1; i <= n; ++i) {
            Collections.sort(lists.get(i));
        }

        DFS(bw, lists, visited, v);
        Arrays.fill(visited, false);
        bw.newLine();
        BFS(bw, lists, visited, v);
        bw.flush();
        bw.close();
        br.close();
    }
}
