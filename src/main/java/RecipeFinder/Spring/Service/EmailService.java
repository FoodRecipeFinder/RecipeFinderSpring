package RecipeFinder.Spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
    MailSender mailSender;


    public void sendOtp(String email,String text,String subject) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(email);
        message.setFrom(System.getenv("MAIL_EMAIL"));
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

}
