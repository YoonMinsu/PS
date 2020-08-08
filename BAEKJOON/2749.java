import java.io.*;

public class Main {
	public static int MOD = 1_000_000;
	public static int PISANO = 1_500_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		long number = Long.parseLong( br.readLine() );
		
		long[] arr = new long[ PISANO ];
		
		arr[ 0 ] = 0; 
		arr[ 1 ] = 1;
		
		for ( int i = 2; i < PISANO && i <= number; ++i ) {
			 arr[ i ] = ( arr[ i - 1 ] + arr[ i - 2 ] ) % MOD;
		}
		
		if ( number >= PISANO ) {
			number = number % PISANO;
		}
		
		System.out.println( arr[ (int)number ] );
		
	}

}
