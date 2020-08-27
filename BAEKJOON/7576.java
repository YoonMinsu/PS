import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public static int m,n;
    public static int maxDay;

    public static boolean checkLoc(int[][] box, int x, int y) {
        if ( x >= 0 && y >= 0 && x < n && y < m) {
            return box[x][y] == 0;
        }
        return false;
    }

    public static void BFS(Queue<Pair> q, int[][] box) {
        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int i = 0; i < 4; ++i) {
                int nextX = pair.getX() + dx[i];
                int nextY = pair.getY() + dy[i];

                if(checkLoc(box, nextX, nextY)) {
                    q.offer(new Pair(nextX, nextY));
                    box[nextX][nextY] = box[pair.getX()][pair.getY()] + 1;
                    maxDay = Math.max(maxDay, box[nextX][nextY]);
                } // end if
            } // end for
        } // end while
    }

    public static boolean isGoodTamato(int[][] box) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        } // end for
        return true;
    }

    public static void print(int[][] box) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] list = br.readLine().split(" ");

        m = Integer.parseInt(list[0]);
        n = Integer.parseInt(list[1]);

        int[][] box = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            list = br.readLine().split(" ");
            for (int j = 0; j < m; ++j) {
                box[i][j] = Integer.parseInt(list[j]);
                if (box[i][j] == 1) {
                    q.offer(new Pair(i, j));
                } // end if
            }
        } // end for

        BFS(q, box);
        if (isGoodTamato(box)) {
            if (maxDay == 0) {
                System.out.println(0);
            } else {
                System.out.println(maxDay - 1);
            }
        } else {
            System.out.println(-1);
        } // end if

    }
}

class Pair {
    private int x;
    private int y;

    public Pair() {}
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
