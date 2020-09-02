import java.io.*;
import java.util.*;

class Pair {
    int start;
    int end;
    public Pair(int start, int end) {
        this.start = start;
        this.end   = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end   = Integer.parseInt(line[1]);
            list.add(new Pair(start, end));
        } // end for

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.end == o2.end) {
                    return Integer.compare(o1.start, o2.end);
                }
                return Integer.compare(o1.end, o2.end);
            }
        });

        int count = 0;
        int end = -1;
        for (int i = 0; i < n; ++i) {
            Pair pair = list.get(i);
            if (pair.start >= end) {
                end = pair.end;
                count++;
            }
        } // end for
        System.out.println(count);

    }
}
