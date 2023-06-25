package com.subhash.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhash.kafka.payload.User;
import com.subhash.kafka.service.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	private static final Logger LOGGER=LoggerFactory.getLogger(JsonMessageController.class);
			
	private JsonKafkaProducer theKafkaProducer;

	public JsonMessageController(JsonKafkaProducer theKafkaProducer) {
		super();
		this.theKafkaProducer = theKafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User theUser){
		
		LOGGER.info(String.format("Message sent fro CLient -> %s", theUser.toString()));
		
		theKafkaProducer.sendMessage(theUser);
		
		return ResponseEntity.ok("Message sent to Kafka Topic.");
	}
}
