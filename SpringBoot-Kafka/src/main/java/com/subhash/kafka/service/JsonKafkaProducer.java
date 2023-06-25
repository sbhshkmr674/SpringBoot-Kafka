package com.subhash.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.subhash.kafka.payload.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String,User>   theKafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> theKafkaTemplate) {
		super();
		this.theKafkaTemplate = theKafkaTemplate;
	}
	
	public void sendMessage(User data) {
		
		LOGGER.info(String.format("Message sent to Kafka server -> %s", data));
		
		Message<User> message=MessageBuilder
								.withPayload(data)
								.setHeader(KafkaHeaders.TOPIC,"jsonTopic")
								.build();
		
		LOGGER.info(String.format("Message sent to Kafka server -> %s", message));
		
		theKafkaTemplate.send(message);
	}
}
