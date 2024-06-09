package com.asidliar.video.statistic.service.services.consumers;

import com.asidliar.video.statistic.service.messages.VideoImpressionMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;

public interface VideoImpressionConsumer {

    void increaseVideoImpression(ConsumerRecord<Long, VideoImpressionMessage> record, Acknowledgment acknowledgment);
}
