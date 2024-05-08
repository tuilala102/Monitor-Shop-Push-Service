package com.mshop.pushservice.config;

import com.mshop.pushservice.constant.Constants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfig {

    @Bean
    public Queue emailQueue() {
        return new Queue(Constants.EMAIL_QUEUE, false);
    }

}
