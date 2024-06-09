package com.asidliar.video.service.services.producers;

import com.asidliar.video.service.messages.VideoImpressionMessage;
import com.asidliar.video.service.utils.KafkaTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VideoImpressionProducerImpl implements VideoImpressionProducer {

    private final KafkaTemplate<Long, VideoImpressionMessage> kafkaTemplate;

    @Autowired
    public VideoImpressionProducerImpl(final KafkaTemplate<Long, VideoImpressionMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void increaseVideoImpression(final Long videoId) {
        kafkaTemplate.send(KafkaTopic.VIDEO_IMPRESSIONS, videoId, new VideoImpressionMessage(videoId));
    }
}
