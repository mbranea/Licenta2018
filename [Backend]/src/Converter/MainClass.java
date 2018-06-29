package src.Converter;

import src.Receiver.ServerSideManagement.PreServer;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
       String inputString = PreServer.receive();
        JSONParser.parseJsonWithString(inputString);
    }
}
