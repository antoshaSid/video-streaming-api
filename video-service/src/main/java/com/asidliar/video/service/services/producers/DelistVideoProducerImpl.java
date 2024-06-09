package com.asidliar.video.service.services.producers;

import com.asidliar.video.service.messages.DelistVideoMessage;
import com.asidliar.video.service.utils.KafkaTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DelistVideoProducerImpl implements DelistVideoProducer {

    private final KafkaTemplate<Long, DelistVideoMessage> kafkaTemplate;

    @Autowired
    public DelistVideoProducerImpl(final KafkaTemplate<Long, DelistVideoMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void delistVideo(final Long videoId) {
        kafkaTemplate.send(KafkaTopic.DELIST_VIDEO, videoId, new DelistVideoMessage(videoId));
    }
}
