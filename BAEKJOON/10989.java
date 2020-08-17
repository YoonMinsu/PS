import java.io.*;

class BaekJoon_10989 {
    private static int[] arr = new int[10_001];

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; ++i) {
            int value = Integer.parseInt(br.readLine());
            arr[value]++;
        }

        for (int i = 1; i <= 10000; ++i) {
            for (int j = 0; j < arr[i]; ++j) {
                bw.write(i + "\n");
            }
        } // end for
        bw.flush();
        bw.close();
        br.close();


    }

    public void run() throws IOException {
        solution();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_10989().run();
    }
}
