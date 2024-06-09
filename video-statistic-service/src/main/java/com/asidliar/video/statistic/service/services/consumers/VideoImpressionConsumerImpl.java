package com.asidliar.video.statistic.service.services.consumers;

import com.asidliar.video.statistic.service.messages.VideoImpressionMessage;
import com.asidliar.video.statistic.service.repositories.VideoStatisticRepository;
import com.asidliar.video.statistic.service.utils.KafkaConsumerGroup;
import com.asidliar.video.statistic.service.utils.KafkaTopic;
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
public class VideoImpressionConsumerImpl implements VideoImpressionConsumer {

    private final VideoStatisticRepository videoStatisticRepository;

    @Autowired
    public VideoImpressionConsumerImpl(final VideoStatisticRepository videoStatisticRepository) {
        this.videoStatisticRepository = videoStatisticRepository;
    }

    @KafkaListener(topics = KafkaTopic.VIDEO_IMPRESSIONS,
                   groupId = KafkaConsumerGroup.VIDEO_IMPRESSIONS_CONSUMER_GROUP)
    @Override
    public void increaseVideoImpression(final ConsumerRecord<Long, VideoImpressionMessage> record,
                                        final Acknowledgment acknowledgment) {
        try {
            final Long videoId = record.value().videoId();
            videoStatisticRepository.increaseVideoImpression(videoId);
            acknowledgment.acknowledge();
        } catch (final Exception e) {
            log.error("Error occurred while processing video impression message with statistic service", e);
            throw e;
        }
    }
}
