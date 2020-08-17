import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Person {
    int age;
    String name;
    int index;

    public Person(int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}

class BaekJoon_10814 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Person[] people = new Person[num+1];
        people[0] = new Person(0,"dummy",0);
        
        for (int i = 1; i <= num; ++i) {
            String[] list = br.readLine().split(" ");
            int age = Integer.parseInt(list[0]);
            String name = list[1];
            people[i] = new Person(age, name, i);
        } // end for

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age == o2.age) {
                    return Integer.compare(o1.index, o2.index);
                } else {
                    return Integer.compare(o1.age, o2.age);
                }
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= num; ++i) {
            bw.write(people[i].age + " " + people[i].name + "\n") ;
        }
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
        new BaekJoon_10814().run();
    }
}
