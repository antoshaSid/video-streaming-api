package com.asidliar.video.metadata.service.services.consumers;

import com.asidliar.video.metadata.service.messages.SuccessPublishVideoMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;

public interface SuccessPublishVideoConsumer {

    void successPublishVideo(ConsumerRecord<Long, SuccessPublishVideoMessage> record, Acknowledgment acknowledgment);
}
