package com.asidliar.video.statistic.service.utils;

public final class KafkaConsumerGroup {

    private KafkaConsumerGroup() {
    }

    public static final String SUCCESS_PUBLISH_VIDEO_CONSUMER_GROUP = "statistic-success-publish-video-consumer-group";

    public static final String VIDEO_IMPRESSIONS_CONSUMER_GROUP = "video-impressions-consumer-group";

    public static final String VIDEO_VIEWS_CONSUMER_GROUP = "video-views-consumer-group";
}
