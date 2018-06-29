package src.Mail;


import java.util.Properties;
import java.util.logging.Level;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Mail {

    final static  String username = "mbranea32@gmail.com";
    final static String  password = "gkqyhqxzmvpbackk";





    private static Properties setProperties()
    {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        return props;
    }
    private static Session setSession(Properties props)
    {
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        session.setDebug(true);
        return session;
    }
    private static void setContent(Session session,String eMail)
    {
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress( "mbranea32@gmail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(eMail));
            msg.setSubject("Generated skill matrix");
            Multipart multipart = new MimeMultipart();
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Hello, in the attached folder you will find the requested skill matrix in pdf form");
            MimeBodyPart attachmentBodyPart= new MimeBodyPart();
            DataSource source = new FileDataSource("example.pdf"); // ex : "C:\\test.pdf"
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("SkillMatrix.pdf"); // ex : "test.pdf"
            multipart.addBodyPart(textBodyPart);  // add the text part
            multipart.addBodyPart(attachmentBodyPart); // add the attachement part
            msg.setContent(multipart);
            Transport.send(msg);
        } catch (MessagingException e) {
            LOGGER.log(Level.SEVERE,"Error while sending email",e);
        }
    }
    public static void sendMail(String eMail) {

        Properties props = setProperties();
        Session session = setSession(props);
        setContent(session,eMail);





    }
}