package com.straders.service.algobase.messenger;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

public class Publisher {

	CachingConnectionFactory connectionFactory;

	RabbitAdmin admin;

	RabbitTemplate template;

	public Publisher(String queue, String topicExchange, String routingKey) {
		connectionFactory = Messenger.connection().getConnection();
		template = getTemplate(queue, topicExchange, routingKey);
	}

	public <T> void publish(String routingKey, T entity) {
		try {
			template.convertAndSend(routingKey, entity);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			connectionFactory.destroy();
		}
	}

	public RabbitTemplate getTemplate(String queue, String topicExchange, String routingKey) {
		admin = new RabbitAdmin(connectionFactory);
		bindingQueue(queue, topicExchange, routingKey);
		RabbitTemplate rabbitTemplate = admin.getRabbitTemplate();
		rabbitTemplate.setMessageConverter(getConverter());
		return rabbitTemplate;
	}

	private void bindingQueue(String queue, String topicExchange, String key) {
		Queue queues = new Queue(queue, true, false, false);
		TopicExchange exchange = new TopicExchange(topicExchange, true, true, null);
		Binding binding = new Binding(topicExchange, Binding.DestinationType.QUEUE, topicExchange, key, null);
		admin.declareQueue(queues);
		admin.declareExchange(exchange);
		admin.declareBinding(binding);
	}

	public MessageConverter getConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
