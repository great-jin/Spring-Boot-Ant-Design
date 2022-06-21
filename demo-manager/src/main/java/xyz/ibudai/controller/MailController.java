package xyz.ibudai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import xyz.ibudai.entity.model.Mail;

@RestController
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send")
    public void SendMail(@RequestBody Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getOwner());
        message.setTo(mail.getTarget());
        message.setSubject(mail.getSubject());
        message.setText(mail.getMessage());

        mailSender.send(message);
    }
}
