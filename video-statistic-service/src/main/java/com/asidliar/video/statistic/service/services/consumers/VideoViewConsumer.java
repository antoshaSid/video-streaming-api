package com.asidliar.video.statistic.service.services.consumers;

import com.asidliar.video.statistic.service.messages.VideoViewMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;

public interface VideoViewConsumer {

    void increaseVideoView(ConsumerRecord<Long, VideoViewMessage> record, Acknowledgment acknowledgment);
}
