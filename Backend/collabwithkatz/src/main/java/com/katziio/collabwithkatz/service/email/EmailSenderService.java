package com.katziio.collabwithkatz.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

    public void initiateEmail(String confirmationToken,String toEmail,boolean isCreator)
    {
        if (isCreator)
        {
            System.out.println("creator verify");
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(toEmail);
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("sanvignesh7890@gmail.com");
            System.out.println(mailMessage.getText());
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8000/v1/auth/creator/verifyCreator/" + confirmationToken);
            this.sendEmail(mailMessage);
        }else {
            System.out.println("editor verify");
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(toEmail);
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("sanvignesh7890@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8000/v1/auth/editor/verifyEditor/" + confirmationToken);
            System.out.println(mailMessage.getText());
            this.sendEmail(mailMessage);
        }
    }
}