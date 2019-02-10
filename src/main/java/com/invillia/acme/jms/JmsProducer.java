package com.invillia.acme.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.invillia.acme.domain.Store;

@Component
public class JmsProducer {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private JmsTemplate jmsTemplateTopic;

	public void sendToQueue(Store store) {
		jmsTemplate.convertAndSend("queue.stores", store);
	}

	public void sendToTopic(Store str) {
		jmsTemplateTopic.convertAndSend("topic.stores", str);
	}

}
