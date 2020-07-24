import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Medal {
    int countryCode;
    int goldMedal;
    int silverMedal;
    int bronzeMedal;
    int rank;

    public Medal() { }
    public Medal( int countryCode, int goldMedal, int silverMedal, int bronzeMedal, int rank ) {
        this.countryCode = countryCode;
        this.goldMedal = goldMedal;
        this.silverMedal = silverMedal;
        this.bronzeMedal = bronzeMedal;
        this.rank = rank;
    }
}
public class Main {



    public static void calcRank( Medal[] medals ) {
        int rank = 1;

        int length = medals.length;
        for ( int i = 1; i < length; ++i ) {


            if ( medals[ i ].goldMedal == medals[ i - 1 ].goldMedal
              && medals[ i ].silverMedal == medals[ i - 1 ].silverMedal
              && medals[ i ].bronzeMedal == medals[ i - 1 ].bronzeMedal ) {

                medals[ i ].rank = medals[ i - 1 ].rank;
            } else {

                medals[ i ].rank = i + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
        int code = 0, gold = 0, silver = 0, bronze = 0;


        String[] line = br.readLine().split( " " );
        int n = Integer.parseInt( line[ 0 ] ); // 국가의 수
        int k = Integer.parseInt( line[ 1 ] ); // 알고 싶은 국가

        Medal[] medals = new Medal[ n ];


        for ( int i = 0; i < n; ++i ) {

            line = br.readLine().split( " " );
            code = Integer.parseInt( line[ 0 ] );
            gold = Integer.parseInt( line[ 1 ] );
            silver = Integer.parseInt( line[ 2 ] );
            bronze = Integer.parseInt( line[ 3 ] );

            medals[ i ] = new Medal( code, gold, silver, bronze, 1 );
        }

        Arrays.sort(medals, new Comparator<Medal>() {
            @Override
            public int compare(Medal o1, Medal o2) {
                if( o1.goldMedal > o2.goldMedal ) {
                    return -1;
                } else if ( o1.goldMedal == o2.goldMedal ) {
                    if( o1.silverMedal > o2.silverMedal ) {
                        return -1;
                    }else if ( o1.silverMedal == o2.silverMedal ) {
                        if( o1.bronzeMedal > o2.bronzeMedal ) {
                            return -1;
                        } else if ( o1.bronzeMedal == o2.bronzeMedal ) {
                            return 0;
                        }
                    }
                }
                return 1;
            }
        });

        calcRank( medals );


        for ( Medal value : medals ) {
            if ( value.countryCode == k ) {
                System.out.println( value.rank );
            }
        }

    }
}


