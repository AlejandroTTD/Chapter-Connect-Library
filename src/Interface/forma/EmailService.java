package Interface.forma;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EmailService {

    private static final String EMAIL_USER = "davidcuasquer21@gmail.com";
    private static final String EMAIL_PASSWORD = "yagmqhekhtqsjwkg";

    public void sendEmail(String recipient, String subject, String body, String attachmentPath)
            throws MessagingException {
        // Configurar propiedades del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Crear sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USER, EMAIL_PASSWORD);
            }
        });

        // Crear el mensaje
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_USER));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);

        // Crear el cuerpo del mensaje
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);

        // Crear el archivo adjunto
        MimeBodyPart attachmentPart = new MimeBodyPart();
        try {
            attachmentPart.attachFile(new File(attachmentPath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        // Combinar el cuerpo del mensaje y el archivo adjunto
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        // Enviar el mensaje
        Transport.send(message);
    }
}
