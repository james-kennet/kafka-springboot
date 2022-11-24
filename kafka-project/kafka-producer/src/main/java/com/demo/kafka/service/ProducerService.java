package com.demo.kafka.service;

import com.demo.kafka.dto.TopicDto;
import com.demo.kafka.dto.TopicDtoUpdate;

public interface ProducerService {

	void send(String topic, TopicDto topicDto);

	void sendUpdate(String topic, TopicDtoUpdate topicDto);
}
