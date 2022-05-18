package com.projecttypea.typea.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.projecttypea.typea.bean.MailMessages;
import com.projecttypea.typea.dao.MailMessageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailMessagesService {

    @Autowired
    MailMessageDao mailMessageDao;

    @Autowired
    JavaMailSender emailSender;

    public int sendMail(MailMessages mailMessages) {

        String body = "Mme Hanane NEKOUA\nDIVISION RECHERCHE SCIENTIFIQUE\nPRÉSIDENCE UNIVERSITÉ CADI AYYAD\nBP 511, Av Moulay Abdellah, Marrakech\nTél : 05 24 43 48 13/14\nFax : 05 24 43 44 94\nCourrier : ha.nekoua@uca.ma";

        mailMessages.setBody(body);
        MimeMessage mssg = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mssg, true);
            helper.setFrom("spring.email.from@gmail.com");
            helper.setTo(mailMessages.getToEmail());
            helper.setSubject(mailMessages.getSubject());
            helper.setText(mailMessages.getBody());

            FileSystemResource file = new FileSystemResource(mailMessages.getPathToAttachement());
            helper.addAttachment(file.getFilename(), file);
            emailSender.send(mssg);
            return 1;
        } catch (MessagingException e) {
            return -1;
        }
    }
}
