package com.asidliar.video.metadata.service.services.consumers;

import com.asidliar.video.metadata.service.messages.DelistVideoMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;

public interface DelistVideoConsumer {

    void delistVideo(ConsumerRecord<Long, DelistVideoMessage> record, Acknowledgment acknowledgment);
}
