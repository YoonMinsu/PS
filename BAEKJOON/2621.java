import java.io.*;
import java.util.Arrays;

public class Main {
    static final int SIZE = 5;

    static String[] cardName;
    static int[] cardNumber;
    static int[] count;

    static boolean flag;
    static int max, sameNum1, sameNum2;

    /* 카드 리스트 초기화*/
    public static void initCardList() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in )) ;

        cardName   = new String[ SIZE ];
        cardNumber = new int[ SIZE ];


        String name;
        int number;

        //input
        for ( int i = 0; i < 5; ++i ) {
            String[] line = br.readLine().split( " " );

            name   = line[ 0 ];
            number = Integer.parseInt( line[ 1 ] );

            cardName[ i ]   = name;
            cardNumber[ i ] = number;

            max = Math.max( max, number );
        }

        Arrays.sort( cardNumber );
    }

    /* 5장의 카드가 모두 같은 색을 가지는지 확인*/
    private static boolean isAllSameColor() {
        String temp = cardName[ 0 ];
        for ( int i = 1; i < SIZE; ++i ) {
            if( !temp.equals( cardName[ i ] ) ) {
                return false;
            }
        }
        return true;
    }

    /* 5장의 카드의 숫자가 연속적인지 확인*/
    private static boolean isCardNumberContinue() {

        for ( int i = 1; i < SIZE; ++i ) {
            int prev = cardNumber[ i - 1 ];
            int next = cardNumber[ i ];
            if ( !(prev - next == -1) ) {
                return false;
            }
        }
        return true;
    }

    /* 같은 숫자 개수 확인 */
    private static int cntSameNumber() {
        int maxCnt = 0;
        int index = 0;
        count = new int[ max + 1 ];

        for ( int i = 0; i < SIZE; ++i ) {
            count[ cardNumber[ i ] ]++;
        }

        for ( int i = 1; i <= max; ++i ) {
            maxCnt = Math.max( maxCnt, count[ i ] );
        }

        for ( int i = 1; i <= max; ++i ) {
            if ( maxCnt == count[ i ] ) {
                sameNum1 = i;
                index = i;
            }
        }

        if( maxCnt == 3 ) {
            for ( int i = 1; i <= max; ++i ) {
                if ( count[ i ] == 2 && i != index ) {
                    sameNum2 = i;

                }
            }
        }

        if ( maxCnt == 2 ) {
            for ( int i = 1; i <= max; ++i ) {
                if ( count[ i ] == 2 && i != index ) {
                    sameNum2 = i;
                }
            }
        }

        return maxCnt;
    }


    public static void solution() throws IOException {

        initCardList();

        // 1
        if (isAllSameColor() && isCardNumberContinue() ) {
            System.out.println( cardNumber[ SIZE - 1 ] + 900 );
            flag = true;
            return;
        }

        // 2
        if ( cntSameNumber() == 4 ) {
            System.out.println( sameNum1 + 800 );
            flag = true;
            return;
        }

        // 3 & 6
        if( cntSameNumber() == 3 ) {
            if ( sameNum2 != 0 ) {
                System.out.println( sameNum1 * 10 + sameNum2 + 700 );
                flag = true;
                return;
            }
            if( !flag ) {
                System.out.println( sameNum1 + 400 );
                flag = true;
                return;
            }
        }

        // 4
        if ( isAllSameColor() ) {
            System.out.println( cardNumber[ SIZE - 1 ] + 600 );
            flag = true;
            return;
        }

        //5
        if ( isCardNumberContinue() ) {
            System.out.println( cardNumber[ SIZE - 1 ] + 500 );
            flag = true;
            return;
        }

        // 7 & 8
        if ( cntSameNumber() == 2 ) {
            if ( sameNum2 != 0 ) {
                if ( sameNum1 > sameNum2 ) {
                    System.out.println( sameNum1 * 10 + sameNum2 + 300 );
                } else {
                    System.out.println( sameNum2 * 10 + sameNum1 + 300 );
                }
                flag = true;
                return;
            }
            if( !flag ) {
                System.out.println( sameNum1 + 200 );
                flag = true;
                return;
            }
        }
        
        // 9
        if( !flag ) {
            System.out.println( cardNumber[ SIZE - 1 ] + 100 );
        }

    }
    public static void main( String[] args ) throws IOException {

        solution();
    }
}
