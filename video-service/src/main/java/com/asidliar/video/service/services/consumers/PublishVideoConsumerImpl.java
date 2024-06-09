package com.asidliar.video.service.services.consumers;

import com.asidliar.video.service.entities.VideoEntity;
import com.asidliar.video.service.messages.PublishVideoMessage;
import com.asidliar.video.service.messages.SuccessPublishVideoMessage;
import com.asidliar.video.service.repositories.VideoRepository;
import com.asidliar.video.service.services.producers.SuccessPublishVideoProducer;
import com.asidliar.video.service.utils.KafkaConsumerGroup;
import com.asidliar.video.service.utils.KafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class PublishVideoConsumerImpl implements PublishVideoConsumer {

    private final VideoRepository videoRepository;
    private final SuccessPublishVideoProducer successPublishVideoProducer;

    @Autowired
    public PublishVideoConsumerImpl(final VideoRepository videoRepository,
                                    final SuccessPublishVideoProducer successPublishVideoProducer) {
        this.videoRepository = videoRepository;
        this.successPublishVideoProducer = successPublishVideoProducer;
    }

    @Override
    @KafkaListener(topics = KafkaTopic.PUBLISH_VIDEO, groupId = KafkaConsumerGroup.PUBLISH_VIDEO_CONSUMER_GROUP)
    public void publishVideo(final ConsumerRecord<String, PublishVideoMessage> record, final Acknowledgment acknowledgment) {
        try {
            final PublishVideoMessage message = record.value();

            VideoEntity newVideo = new VideoEntity(message.content());
            newVideo = videoRepository.save(newVideo);

            successPublishVideoProducer.successPublishVideo(new SuccessPublishVideoMessage(newVideo.getId(), message.title(), message.content()));

            acknowledgment.acknowledge();
        } catch (final Exception e) {
            log.error("Error processing message", e);
            throw e;
        }
    }
}
