package be.brahms.services.impl;

import be.brahms.services.EmailServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServImpl  implements EmailServ {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendingEmail( String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Chess@Tournament.be");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
}
