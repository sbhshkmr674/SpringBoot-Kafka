package com.subhash.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaFirstConsumerService {

	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaFirstConsumerService.class);
	
	@KafkaListener(topics="NewTopic",groupId="myGroup")
	public void readMessageFromKafkaTopic(String message) {
		
		LOGGER.info(String.format("Message received from Kafka server -> %s", message));
	}
}
