import java.io.*;
public class Main {
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};

    public static int areaSize;
    public static int maxHeight;

    public static int[][] initArr(BufferedReader br, int size) throws IOException {
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; ++i) {
            String[] list = br.readLine().split(" ");
            for (int j = 0; j < size; ++j) {
                arr[i][j] = Integer.parseInt(list[j]);
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                } // end if
            } // end inner for
        } // end outer for
        return arr;
    }

    public static boolean checkLoc(int[][] area, boolean[][] visited, int x, int y, int height) {
        if (x >= 0 && y >= 0 && x < areaSize && y < areaSize) {
            return area[x][y] > height && !visited[x][y];
        } // end if
        return false;
    }

    public static void DFS(int[][] area, boolean[][] visited, int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(checkLoc(area, visited, nextX, nextY, height)) {
                DFS(area, visited, nextX, nextY, height);
            } // end if
        } // end for
    }

    public static int getSafeArea(int[][] area, int height) {
        boolean[][] visited = new boolean[areaSize][areaSize];

        int cnt = 0;
        for (int i = 0; i < areaSize; ++i) {
            for (int j = 0; j < areaSize; ++j) {
                if (area[i][j] > height && !visited[i][j] ) {
                    DFS(area, visited, i, j, height);
                    cnt = cnt + 1;
                }
            }
        } // end for

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        areaSize = Integer.parseInt(br.readLine());

        int[][] arr = initArr(br, areaSize);

        int maxSafeArea = 0;
        for (int i = 0; i <= maxHeight; ++i) {
            int cnt = getSafeArea(arr, i);
            maxSafeArea = Math.max(maxSafeArea, cnt);
        } // end for
        System.out.println(maxSafeArea);

    }
}
