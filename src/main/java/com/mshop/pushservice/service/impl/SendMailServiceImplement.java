package com.mshop.pushservice.service.impl;

import com.mshop.pushservice.constant.Constants;
import com.mshop.pushservice.constant.Utils;
import com.mshop.pushservice.dto.MailInfo;
import com.mshop.pushservice.service.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Slf4j
public class SendMailServiceImplement implements SendMailService {

    @Autowired
    JavaMailSender sender;

    @RabbitListener(queues = Constants.EMAIL_QUEUE)
    // message queue: xu ly message
    public void consumeSendMailMsg(String msg) {
        MailInfo mailInfo = Utils.convertFromJson(msg, MailInfo.class);
        try {
            send(mailInfo);
            log.info("Da gui mail toi: {}. Tieu de: {}", mailInfo.getTo(), mailInfo.getSubject());
        } catch (Exception e) {
            log.error("Co loi khi gui mail", e);
        }
    }

    @Override
    public void send(MailInfo mail) throws MessagingException {
        // Tạo message
        MimeMessage message = sender.createMimeMessage();
        // Sử dụng Helper để thiết lập các thông tin cần thiết cho message
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setFrom(mail.getFrom());
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getBody(), true);
        helper.setReplyTo(mail.getFrom());

        if (mail.getAttachments() != null) {
            FileSystemResource file = new FileSystemResource(new File(mail.getAttachments()));
            helper.addAttachment(mail.getAttachments(), file);
        }

        // Gửi message đến SMTP server
        sender.send(message);

    }

}
