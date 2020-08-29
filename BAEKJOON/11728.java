import java.io.*;

public class Main {
    public static void merge(int n, int m, int[] leftArr, int[] rightArr, int[] resultArr) {
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < n && j < m) {
            if (leftArr[i] < rightArr[j]) {
                resultArr[idx] = leftArr[i];
                i = i + 1;
            } else {
                resultArr[idx] = rightArr[j];
                j = j + 1;
            }
            idx = idx + 1;
        } // end while

        while (i < n) {
            resultArr[idx++] = leftArr[i++];
        }

        while (j < m) {
            resultArr[idx++] = rightArr[j++];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] list = br.readLine().split(" ");

        int n = Integer.parseInt(list[0]);
        int m = Integer.parseInt(list[1]);

        int[] leftArr  = new int[n];
        int[] rightArr = new int[m];

        list = br.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            leftArr[i] = Integer.parseInt(list[i]);
        }

        list = br.readLine().split(" ");
        for (int i = 0; i < m; ++i) {
            rightArr[i] = Integer.parseInt(list[i]);
        }

        int size = n + m;
        int[] resultArr = new int[size];

        merge(n, m, leftArr, rightArr, resultArr);

        for (int i = 0; i < size; ++i) {
            bw.write(resultArr[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
