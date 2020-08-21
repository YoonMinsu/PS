import java.io.*;

public class Main {
    public static final int MAX = 300_000;
    public static int[] visited;

    public static void DFS(int[] visited, int num, int p) {
        visited[num]++;

        if (visited[num] == 3) {
            return;
        }
        int sum = 0;
        while (num != 0) {
            sum = sum + (int)Math.pow((num % 10), p);
            num = num / 10;
        }
        DFS(visited, sum, p);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] list = br.readLine().split(" ");

        int a = Integer.parseInt(list[0]);
        int p = Integer.parseInt(list[1]);

        visited = new int[MAX + 1];
        DFS(visited,a,p);

        int result = 0;
        for (int i = 0; i < MAX; ++i) {
            if (visited[i] == 1) {
                result = result + 1;
            }
        } // end for

        System.out.println(result);

    }
}
