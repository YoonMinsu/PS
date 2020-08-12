import java.io.*;

class BaekJoon_11053 {
    private static int[] arr;

    private void initArr(int n, BufferedReader br) throws IOException {
        arr = new int[ n ];

        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i ] );
        }
    }

    private int solve(int n, BufferedReader br) throws IOException {
        initArr(n,br);
        int[] dp = new int[ n ];

        dp[ 0 ] = 1;
        int max = 0;

        for ( int i = 1; i < n; ++i ) {
            dp[ i ] = 1;
            for ( int j = 0; j < i; ++j ) {
                if ( arr[ i ] > arr[ j ] && dp[ j ] + 1 > dp[ i ] ) {
                    dp[ i ] = dp[ j ] + 1;
                }
            }
        } // end for

        for ( int i = 0; i < n; ++i ) {
            max = Math.max( max, dp[ i ] );
        }
        return max;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int result = solve(num, br);

        bw.write(result+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_11053().solution();
    }
}
