package com.asidliar.video.service.services.producers;

import com.asidliar.video.service.messages.VideoViewMessage;
import com.asidliar.video.service.utils.KafkaTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VideoViewProducerImpl implements VideoViewProducer {

    private final KafkaTemplate<Long, VideoViewMessage> kafkaTemplate;

    @Autowired
    public VideoViewProducerImpl(final KafkaTemplate<Long, VideoViewMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void increaseVideoView(final Long videoId) {
        kafkaTemplate.send(KafkaTopic.VIDEO_VIEWS, videoId, new VideoViewMessage(videoId));
    }
}
