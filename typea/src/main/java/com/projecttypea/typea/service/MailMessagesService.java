package com.projecttypea.typea.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import com.projecttypea.typea.bean.MailMessages;
import com.projecttypea.typea.dao.MailMessageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailMessagesService {

    @Autowired
    formulaire form;

    @Autowired
    MailMessageDao mailMessageDao;

    @Autowired
    JavaMailSender emailSender;

    public int sendMail(MailMessages mailMessages, byte[] mail) {
        MimeMessage mssg = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mssg, true);
            helper.setFrom("spring.email.from@gmail.com");
            helper.setTo(mailMessages.getToEmail());
            helper.setSubject(mailMessages.getSubject());
            helper.setText(mailMessages.getBody());
            ByteArrayDataSource file = new ByteArrayDataSource(mail, "application/pdf");
            helper.addAttachment(file.getName(), file);
            emailSender.send(mssg);
            mailMessageDao.save(mailMessages);
            return 1;
        } catch (MessagingException e) {
            return -1;
        }
    }

    public void sendSimpleMail(MailMessages mailMessages) {
        SimpleMailMessage mssg = new SimpleMailMessage();

        mssg.setFrom("spring.email.from@gmail.com");
        mssg.setTo(mailMessages.getToEmail());
        mssg.setText(mailMessages.getBody());
        mssg.setSubject(mailMessages.getSubject());

        emailSender.send(mssg);
    }
}
