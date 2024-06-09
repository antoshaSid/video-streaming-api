package com.asidliar.video.service.services.producers;

import com.asidliar.video.service.messages.PublishVideoMessage;
import com.asidliar.video.service.utils.KafkaTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublishVideoProducerImpl implements PublishVideoProducer {

    private final KafkaTemplate<Long, PublishVideoMessage> kafkaTemplate;

    @Autowired
    public PublishVideoProducerImpl(KafkaTemplate<Long, PublishVideoMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishVideo(final PublishVideoMessage publishVideo) {
        kafkaTemplate.send(KafkaTopic.PUBLISH_VIDEO, publishVideo);
    }
}
