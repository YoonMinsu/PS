

class BaekJoon_11052 {

    private void solution() throws java.io.IOException {
        java.io.BufferedReader br = new java.io.BufferedReader( new java.io.InputStreamReader( java.lang.System.in ) );

        int num = java.lang.Integer.parseInt( br.readLine() );

        int[] dp  = new int[ num + 1 ];

        int[] arr = new int[ num + 1 ];
        java.lang.String[] list = br.readLine().split( " " );
        for ( int i = 1; i <= num; ++i ) {
            arr[ i ] = java.lang.Integer.parseInt( list[ i - 1 ] );
        }


        for ( int i = 1; i <= num; ++i ) {
            for ( int j = 1; j <= i; ++j ) {
                dp[ i ] = java.lang.Math.max( dp[ i ], dp[ i - j ] + arr[ j ] );
            }
        } // end for

        java.lang.System.out.println( dp[ num ] );


    }

    public void run() throws java.io.IOException {
        solution();
    }
}

public class Main {
    public static void main( String[] args ) throws java.io.IOException {
         new BaekJoon_11052().run();
    }
}
