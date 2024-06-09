package com.asidliar.video.service.services.producers;

import com.asidliar.video.service.messages.SuccessPublishVideoMessage;
import com.asidliar.video.service.utils.KafkaTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SuccessPublishVideoProducerImpl implements SuccessPublishVideoProducer {

    private final KafkaTemplate<Long, SuccessPublishVideoMessage> kafkaTemplate;

    @Autowired
    public SuccessPublishVideoProducerImpl(final KafkaTemplate<Long, SuccessPublishVideoMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void successPublishVideo(final SuccessPublishVideoMessage successPublishVideo) {
        kafkaTemplate.send(KafkaTopic.SUCCESS_PUBLISH_VIDEO, successPublishVideo.videoId(), successPublishVideo);
    }
}
