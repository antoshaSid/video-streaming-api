package com.asidliar.video.service.services.consumers;

import com.asidliar.video.service.messages.PublishVideoMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;

public interface PublishVideoConsumer {

    void publishVideo(ConsumerRecord<String, PublishVideoMessage> record, Acknowledgment acknowledgment);
}
