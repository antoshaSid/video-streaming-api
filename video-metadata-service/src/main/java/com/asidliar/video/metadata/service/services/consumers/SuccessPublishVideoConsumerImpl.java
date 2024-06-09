package com.asidliar.video.metadata.service.services.consumers;

import com.asidliar.video.metadata.service.entities.VideoMetadataEntity;
import com.asidliar.video.metadata.service.messages.SuccessPublishVideoMessage;
import com.asidliar.video.metadata.service.repositories.VideoMetadataRepository;
import com.asidliar.video.metadata.service.utils.KafkaConsumerGroup;
import com.asidliar.video.metadata.service.utils.KafkaTopic;
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
public class SuccessPublishVideoConsumerImpl implements SuccessPublishVideoConsumer {

    private final VideoMetadataRepository videoMetadataRepository;

    @Autowired
    public SuccessPublishVideoConsumerImpl(final VideoMetadataRepository videoMetadataRepository) {
        this.videoMetadataRepository = videoMetadataRepository;
    }

    @KafkaListener(topics = KafkaTopic.SUCCESS_PUBLISH_VIDEO,
                   groupId = KafkaConsumerGroup.SUCCESS_PUBLISH_VIDEO_CONSUMER_GROUP)
    @Override
    public void successPublishVideo(final ConsumerRecord<Long, SuccessPublishVideoMessage> record,
                                    final Acknowledgment acknowledgment) {
        try {
            final SuccessPublishVideoMessage videoMessage = record.value();
            final VideoMetadataEntity videoMetadata = VideoMetadataEntity.builder()
                .id(videoMessage.videoId())
                .title(videoMessage.title())
                .isDeleted(false)
                .build();

            videoMetadataRepository.save(videoMetadata);
            acknowledgment.acknowledge();
        } catch (final Exception e) {
            log.error("Error while processing success publish video message", e);
            throw e;
        }
    }
}
