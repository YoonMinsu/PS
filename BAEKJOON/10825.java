import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Student {
    public String name;
    public int korScore;
    public int engScore;
    public int mathScore;

    public Student() {}

    public Student( String name, int korScore, int engScore, int mathScore ) {
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
        this. mathScore = mathScore;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        String name = " ";
        int kor = 0, eng = 0, math = 0;

        int stNum = Integer.parseInt( br.readLine() );

        Student[] st = new Student[ stNum ];

        for ( int i = 0; i < stNum; ++i ) {
            String[] line = br.readLine().split( " " );
            name = line[ 0 ];
            kor = Integer.parseInt( line[ 1 ] );
            eng = Integer.parseInt( line[ 2 ] );
            math = Integer.parseInt( line[ 3 ] );
            st[ i ] = new Student( name, kor, eng, math );
        }

        Arrays.sort(st, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if ( o1.korScore == o2.korScore ) {
                    if ( o1.engScore == o2.engScore ) {
                        if ( o1.mathScore == o2.mathScore ) {
                            return o1.name.compareTo( o2.name );
                        }
                        return Integer.compare( o2.mathScore, o1.mathScore );
                    }
                    return Integer.compare( o1.engScore, o2.engScore );
                }
                return Integer.compare( o2.korScore, o1.korScore );
            }
        });

        for ( int i = 0; i < stNum; ++i ) {
            bw.write( st[ i ].name + '\n' );
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
