package com.asidliar.video.service.utils;

public final class KafkaTopic {

    private KafkaTopic() {
    }

    public static final String PUBLISH_VIDEO = "video.service.publish-video";

    public static final String SUCCESS_PUBLISH_VIDEO = "video.service.success-publish-video";

    public static final String DELIST_VIDEO = "video.service.delist-video";

    public static final String VIDEO_IMPRESSIONS = "video.service.video-impressions";

    public static final String VIDEO_VIEWS = "video.service.video-views";
}
