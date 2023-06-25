package com.subhash.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topicCreation() {
		
		return TopicBuilder
				.name("NewTopic")
				.build();
	}
	
	@Bean
	public NewTopic jsonTopic() {
		
		 return TopicBuilder
				 .name("jsonTopic")
				 .build();
	}
}
