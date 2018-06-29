package src.Receiver.ServerSideManagement;

import org.apache.commons.io.IOUtils;
import src.Converter.JSONParser;
import src.Mail.Mail;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class PreServer {

    private static Socket socket;
    public static String receive()
    {
        String message = null;

        try

        {

            int port = 25001;

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server Started and listening to the port 25000");

            //Server is running always. This is done using this while(true) loop

            while(true)

            {

                //Reading the message from the client

                socket = serverSocket.accept();

                InputStream is = socket.getInputStream();

                InputStreamReader isr = new InputStreamReader(is);

                BufferedReader br = new BufferedReader(isr);


                 message = readerToString(is);

                System.out.println("Message received from client is "+message);

                JSONParser.parseJsonWithString(message);


                //Multiplying the number by 2 and forming the return message
                Mail.sendMail(JSONParser.eMail);






            }

        }

        catch (Exception e)

        {

            e.printStackTrace();

        }

        finally

        {

            try

            {

                socket.close();

            }

            catch(Exception e){}

        }


return message;
    }

    private static String readerToString(InputStream inputStream) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer, "UTF-8");
        return writer.toString();
    }


}
