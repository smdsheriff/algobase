package com.straders.service.algobase.messenger;

import java.util.Objects;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

public class Messenger {

	private CachingConnectionFactory connectionFactory;

	private static Messenger connection;

	public static Messenger connection() {
		return Objects.nonNull(connection) ? connection : new Messenger();
	}

	public CachingConnectionFactory getConnection() {
		if (connectionFactory == null) {
			CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
			connectionFactory.setUsername("guest");
			connectionFactory.setPassword("guest");
			connectionFactory.createConnection();
			return connectionFactory;
		} else {
			return connectionFactory;
		}
	}


}
