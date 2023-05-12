package DataFiles;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class OTP
{
    private int randomPin;
    public int generateOTP()
    {
        randomPin = (int) (Math.random()*9000);
        return randomPin;
    }

    public void sendEmail(String email) throws MessagingException
    {
        try
       {
            String to = email;
            String from = "toffeeotp@gmail.com";
            String host = "smtp.gmail.com";
            String helo = "smtp.gmail.com";
            String username = "toffeeotp@gmail.com";
            String password = "uvrmejpwalvmjtpn";

            Properties properties = new Properties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.localhost", helo);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Toffee Store");
            message.setText("OTP is: " + String.valueOf(randomPin));

            Transport.send(message);
            System.out.println("Email sent successfully.");
       }
      catch (MessagingException mex)
       {
           mex.printStackTrace();
      }
    }
}
