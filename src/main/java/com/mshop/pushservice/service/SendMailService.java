package com.mshop.pushservice.service;


import com.mshop.pushservice.dto.MailInfo;

import javax.mail.MessagingException;
import java.io.IOException;

public interface SendMailService {

    void send(MailInfo mail) throws MessagingException, IOException;

}
