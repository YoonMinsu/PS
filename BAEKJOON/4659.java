import java.io.*;

public class Main {

    /* 모음이 반드시 하나는 있는지? */
    private static boolean checkVowel( char[] str ) {

        int length = str.length;
        for ( int i = 0; i < length; ++i ) {
            if( isVowel( str[ i ] ) ) {
                return true;
            }
        }
        return false;
    }

    /* 같은 글자가 연속으로 두번 오면 되는지 검사
    *  예외 ( ee, oo )
    * */
    private static boolean isSameWordTwice( char[] str ) {

        int length = str.length;
        String checkStr = "";

        for ( int i = 1; i < length; ++i ) {
            checkStr = String.valueOf( str[ i ] ) + String.valueOf( str[ i - 1 ] );
            if ( checkStr.equals("ee") || checkStr.equals("oo") ) {
                continue;
            }
            if ( str[ i - 1 ] == str[ i ] ) {
                return false;
            }
        }
        return true;
    }

    /* 모음이 3개 혹은 자음이 3개 연속으로 오는지 검사*/
    private static boolean isContinue( char[] str ) {

        int length = str.length;
        for ( int i = 0; i < length - 2; ++i ) {

            // 모음
            if( isVowel( str[ i ] ) && isVowel( str[ i + 1 ] ) && isVowel( str[ i + 2 ] ) ) {
                return false;
            }

            // 자음
            if( isConsonant( str[ i ] ) && isConsonant( str[ i + 1 ] ) && isConsonant( str[ i + 2 ] ) ) {
                return false;
            }
        }

        return true;
    }

    /* 자음 검사*/
    private static boolean isConsonant( char word ) {
        if ( word != 'a' && word != 'e' && word != 'i' && word != 'o' && word != 'u' ) {
            return true;
        }
        return false;
    }

    /* 모음 검사*/
    private static boolean isVowel( char word ) {

        if ( word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u' ) {
            return true;
        }

        return false;
    }

    /* 좋은 비밀번호 검사 */
    public static boolean isGoodPassWord( String cmd ) {

        char[] str = cmd.toCharArray();

        if ( checkVowel( str ) ) {

            if ( !isContinue( str ) || !isSameWordTwice( str ) ) {
                return false;
            }

            if ( isSameWordTwice( str ) ) {
                return true;
            }
        }
        return false;
    }



    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        String cmd = br.readLine();

        while ( !cmd.equals( "end" ) ) {

            if ( isGoodPassWord( cmd ) ) {

                bw.write( "<" + cmd + "> is acceptable." );

            } else {

                bw.write( "<" + cmd + "> is not acceptable." );

            }
            bw.write( '\n' );
            bw.flush();

            cmd = br.readLine();

        } // end while
        bw.close();
        br.close();

    }
}
