package src.Receiver.ServerSideManagement;

/**
 * Created by arty on 30.04.15.
 */
public class MainApp {
    public static void main(String[] args) {

        int portNumber = Integer.parseInt("1000");

       Server s = new Server(portNumber);
        s.start ();
    }
}
