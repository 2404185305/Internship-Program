package com.taoli.youtu.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.IConfigurationAnnotation;

@IConfigurationAnnotation
public class RabbitMQConfig {

    public static final String ENROLL_EXCHANGE = "ex.taoli.enrollment";
    public static final String SMS_QUEUE = "q.taoli.notification.sms";
    public static final String BONUS_QUEUE = "q.taoli.finance.bonus";
    public static final String ROUTING_KEY = "enroll.success";

    @Bean
    public TopicExchange enrollExchange() {
        return new TopicExchange(ENROLL_EXCHANGE, true, false);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue(SMS_QUEUE, true);
    }

    @Bean
    public Queue bonusQueue() {
        return new Queue(BONUS_QUEUE, true);
    }

    @Bean
    public Binding bindingSms(Queue smsQueue, TopicExchange enrollExchange) {
        return BindingBuilder.bind(smsQueue).to(enrollExchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding bindingBonus(Queue bonusQueue, TopicExchange enrollExchange) {
        return BindingBuilder.bind(bonusQueue).to(enrollExchange).with(ROUTING_KEY);
    }
}