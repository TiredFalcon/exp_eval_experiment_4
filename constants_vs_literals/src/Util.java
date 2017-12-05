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

    static public class Client {
        public Client() {

        }

        public void acceptResponse(int status) {
            // blub
        }

        public void rejectResponse(int status) {
            // blub
        }

        public String getRequest() {
            return "request";
        }
    }

    static public class Database {
        public Database() {

        }

        public int query(String queryString) {
            return 0;
        }


    }
}
