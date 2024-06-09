package com.asidliar.video.statistic.service.services.consumers;

import com.asidliar.video.statistic.service.entities.VideoStatisticEntity;
import com.asidliar.video.statistic.service.messages.SuccessPublishVideoMessage;
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
public class SuccessPublishVideoConsumerImpl implements SuccessPublishVideoConsumer {

    private final VideoStatisticRepository videoStatisticRepository;

    @Autowired
    public SuccessPublishVideoConsumerImpl(final VideoStatisticRepository videoStatisticRepository) {
        this.videoStatisticRepository = videoStatisticRepository;
    }

    @KafkaListener(topics = KafkaTopic.SUCCESS_PUBLISH_VIDEO,
                   groupId = KafkaConsumerGroup.SUCCESS_PUBLISH_VIDEO_CONSUMER_GROUP)
    @Override
    public void successPublishVideo(final ConsumerRecord<Long, SuccessPublishVideoMessage> record,
                                    final Acknowledgment acknowledgment) {
        try {
            final VideoStatisticEntity videoStatistic = VideoStatisticEntity.builder()
                .id(record.value().videoId())
                .impressions(0L)
                .views(0L)
                .build();
            videoStatisticRepository.save(videoStatistic);
            acknowledgment.acknowledge();
        } catch (Exception e) {
            log.error("Error occurred while processing success publish video message with statistic service", e);
            throw e;
        }
    }
}
