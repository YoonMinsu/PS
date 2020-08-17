import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left  = left;
        this.right = right;
    }
}
class BaekJoon_11650 {
        private void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int num = Integer.parseInt(br.readLine());

            Pair[] pairs = new Pair[ num ];

            for (int i = 0; i < num; ++i) {
                String[] list = br.readLine().split(" ");
                int left  = Integer.parseInt(list[0]);
                int right = Integer.parseInt(list[1]);
                pairs[i] = new Pair(left, right);
            } // end for

            Arrays.sort(pairs, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.left == o2.left) {
                        return Integer.compare(o1.right, o2.right);
                    } else {
                        return Integer.compare(o1.left, o2.left);
                    }
                }
            });
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < num; ++i) {
                bw.write(pairs[i].left + " " + pairs[i].right + "\n");
            }
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
        new BaekJoon_11650().run();
    }
}
