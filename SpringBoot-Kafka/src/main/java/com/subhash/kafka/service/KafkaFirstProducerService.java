package com.subhash.kafka.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaFirstProducerService {

	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaFirstProducerService.class);
	
	
	private KafkaTemplate<String,String> kafkaTemplate;

	public KafkaFirstProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

    
	public void produceMessageToKafkaTopic(String message) {
		
		LOGGER.info(String.format("Message send to Kafka Topic NewTopic -> %s",message));
		
		kafkaTemplate.send("NewTopic", message);
		
	}
}
