package src.Sender.ClientSideManagement;

/**
 * Created by arty on 30.04.15.
 */
public class MainApp {
    public static void main(String[] args) {

        String hostName ="127.0.0.1";
        int portNumber = Integer.parseInt("1000");
        Client c = new Client("C:\\Users\\madalin.branea\\AndroidStudioProjects\\MyApplication\\app\\src\\main\\java\\example-Copy.json", hostName, portNumber);
        c.start();
    }
}
