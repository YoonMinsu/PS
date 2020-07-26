import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[19][19];
    static int ansX, ansY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = false;
        here : for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(map[i][j] != 0 && isTrue(i, j, map[i][j])) {
                    System.out.println(map[i][j]);
                    System.out.println((ansX+1) + " " + (ansY+1));
                    flag = true;
                    break here;
                }
            }
        }

        if(!flag)
            System.out.println("0");
    }

    static boolean isTrue(int x, int y, int num) {
        //가로
        int nextX = x;
        int nextY = y;
        int cnt = 1;
        while(true) { // 왼쪽 확인
            nextY--;
            if(!isRange(nextX, nextY) || num != map[nextX][nextY] || cnt > 5)
                break;
            cnt++;
        }
        nextY = y;
        while(true) { // 오른쪽 확인
            nextY++;
            if(!isRange(nextX, nextY) || num != map[nextX][nextY] || cnt > 5)
                break;
            cnt++;
        }
        if(cnt == 5) {
            ansX = x;
            ansY = y;
            return true;
        }
        //세로
        nextY = y;
        cnt = 1;
        while(true) { // 위쪽 확인
            nextX--;
            if(!isRange(nextX, nextY) || num != map[nextX][nextY] || cnt > 5)
                break;
            cnt++;
        }
        nextX = x;
        while(true) { // 아래쪽 확인
            nextX++;
            if(!isRange(nextX, nextY) || num != map[nextX][nextY] || cnt > 5)
                break;
            cnt++;
        }
        if(cnt == 5) {
            ansX = x;
            ansY = y;
            return true;
        }

        //왼오 대각선
        nextX = x;
        cnt = 1;
        while(true) { // 왼쪽 위 확인
            nextX--; nextY--;
            if(!isRange(nextX, nextY) || num != map[nextX][nextY] || cnt > 5)
                break;
            cnt++;
        }
        nextX = x;
        nextY = y;
        while(true) { // 오른쪽 아래 확인
            nextX++; nextY++;
            if(!isRange(nextX, nextY) || num != map[nextX][nextY] || cnt > 5)
                break;
            cnt++;
        }
        if(cnt == 5) {
            ansX = x;
            ansY = y;
            return true;
        }

        //오왼 대각선
        nextX = x;
        nextY = y;
        cnt = 1;
        while(true) { // 오른쪽 위 확인
            nextX--; nextY++;
            if(!isRange(nextX, nextY) || num != map[nextX][nextY] || cnt > 5)
                break;
            cnt++;
        }
        nextX = x;
        nextY = y;
        while(true) { // 왼쪽 아래 확인
            nextX++; nextY--;
            if(!isRange(nextX, nextY) || num != map[nextX][nextY] || cnt > 5)
                break;
            cnt++;
        }
        if(cnt == 5) {
            ansX = nextX-1;
            ansY = nextY+1;
            return true;
        }

        return false;
    }

    static boolean isRange(int x, int y) {
        if(x < 0 || x >= 19 || y < 0 || y >= 19)
            return false;
        else
            return true;
    }
}
