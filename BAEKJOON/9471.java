import java.io.*;

public class Main {

	public static int fibo( int m ) {
		int count = 0;
		int f1 = 0, f2 = 1;
		
		while ( true ) {
			if ( f1 == 0 && f2 == 1 && count != 0 ) {
				break;
			}
			int temp = f1;
			f1 = f2;
			f2 = ( temp + f1 ) % m;
			count++;
		} // end while
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		int p = Integer.parseInt( br.readLine() );
	
		while ( p-- > 0 ) {
			
			String[] line = br.readLine().split( " " );
			int n = Integer.parseInt( line[ 0 ] );
			int m = Integer.parseInt( line[ 1 ] );
			
			bw.write( n + " " + fibo( m ) +"\n" );
			 
		} // end while
		
		bw.flush();
		bw.close();
		br.close();
	}

}
