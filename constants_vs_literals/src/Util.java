/**
 * Created by falcon on 05.12.17.
 */
public class Util {

    static public class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public void sendDocument(String text) {
            System.out.println("Sent document to " + this.name + ".\n\n" + text);
        }
    }
}
