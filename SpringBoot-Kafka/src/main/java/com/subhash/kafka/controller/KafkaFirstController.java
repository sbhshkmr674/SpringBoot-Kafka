package com.subhash.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subhash.kafka.config.KafkaConfig;
import com.subhash.kafka.service.KafkaFirstProducerService;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaFirstController {

	@Autowired
	private KafkaFirstProducerService kafkaProducer;
	
	
    //End Point : http://localhost:8080/api/v1/kafka/publish?message=Hello Everyone
	@GetMapping("/publish")
	public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
		
		kafkaProducer.produceMessageToKafkaTopic(message);
		
		return ResponseEntity.ok("Message has sent to Kafka Topic :NewTopic");
	}
}
