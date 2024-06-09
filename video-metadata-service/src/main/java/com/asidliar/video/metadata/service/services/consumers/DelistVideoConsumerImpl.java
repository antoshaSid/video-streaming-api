package com.asidliar.video.metadata.service.services.consumers;

import com.asidliar.video.metadata.service.messages.DelistVideoMessage;
import com.asidliar.video.metadata.service.repositories.VideoMetadataRepository;
import com.asidliar.video.metadata.service.utils.KafkaConsumerGroup;
import com.asidliar.video.metadata.service.utils.KafkaTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DelistVideoConsumerImpl implements DelistVideoConsumer {

    private final VideoMetadataRepository videoMetadataRepository;

    @Autowired
    public DelistVideoConsumerImpl(final VideoMetadataRepository videoMetadataRepository) {
        this.videoMetadataRepository = videoMetadataRepository;
    }

    @KafkaListener(topics = KafkaTopic.DELIST_VIDEO, groupId = KafkaConsumerGroup.DELIST_VIDEO_CONSUMER_GROUP)
    @Override
    public void delistVideo(final ConsumerRecord<Long, DelistVideoMessage> record,
                            final Acknowledgment acknowledgment) {
        videoMetadataRepository.delistVideo(record.value().videoId());
    }
}
