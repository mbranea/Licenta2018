package com.example.madalinbranea.myapplication.ClientSideManagement;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PreClient {

    private static Socket socket;
    public static void send(String jsonStrings)
    {

        try

        {

           // String host = "localhost";
           // String host = "10.227.56.58";
String host = "192.168.43.47";
            //String host = "10.0.2.2";


            int port = 25001;

            InetAddress address = InetAddress.getByName(host);

             socket = new Socket();
            socket.connect(new InetSocketAddress(address, port), 5000);

            //Send the message to the server

            OutputStream os = socket.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os);

            BufferedWriter bw = new BufferedWriter(osw);





            bw.write(jsonStrings);

            bw.flush();

            bw.close();

            System.out.println("Message sent to the server : "+jsonStrings);

            //Get the return message from the server

          //  InputStream is = socket.getInputStream();

           // InputStreamReader isr = new InputStreamReader(is);

           // BufferedReader br = new BufferedReader(isr);

           // String message = br.readLine();

           // System.out.println("Message received from the server : " +message);

        }

        catch (Exception exception)

        {

            exception.printStackTrace();

        }

        finally

        {

            //Closing the socket

            try

            {

                socket.close();

            }

            catch(Exception e)

            {

                e.printStackTrace();

            }

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
   public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile (String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return ret;
    }
}
