package com.onelifedev.emailservice.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onelifedev.emailservice.dtos.SendEmailDto;
import com.onelifedev.emailservice.utils.EmailUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Component
public class SendEmailEventConsumer {
    private ObjectMapper objectMapper;

    public SendEmailEventConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "sendEmail", groupId = "emailServiceGroup")
    public void handleSendEmailEvent(String message) throws JsonProcessingException {
        SendEmailDto emailDto = objectMapper.readValue(
                message,
                SendEmailDto.class
        );

        String email = emailDto.getEmail();
        String subject = emailDto.getSubject();
        String body = emailDto.getBody();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "sharukscalerdemo@gmail.com",
                        "liiwvucxonxsfdnm");
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, email, subject, body);
    }

}
