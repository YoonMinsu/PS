import java.io.*;
import java.util.Stack;

class BaekJoon_9012 {

    private boolean isGoodBracket( char[] bracket ) {
        Stack<Character> stack = new Stack<Character>();

        int length = bracket.length;
        for ( int i = 0; i < length; ++i ) {
            char flag = bracket[ i ];
            if ( flag == '(' ) {
                stack.push( flag );
            }
            if ( flag == ')' ) {
                if ( !stack.isEmpty() ) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        } // end for
        if ( stack.isEmpty() ) {
            return true;
        } else {
            return false;
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt( br.readLine() );

        while ( cnt-- > 0 ) {
            char[] bracket = br.readLine().toCharArray();

            if( isGoodBracket( bracket ) ) {
                bw.write( "YES\n" );
            } else {
                bw.write( "NO\n" );
            }

        } // end while
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
       new BaekJoon_9012().run();
    }
}
