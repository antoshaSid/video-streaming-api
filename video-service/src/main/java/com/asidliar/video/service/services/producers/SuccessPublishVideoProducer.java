package com.asidliar.video.service.services.producers;

import com.asidliar.video.service.messages.SuccessPublishVideoMessage;

public interface SuccessPublishVideoProducer {

    void successPublishVideo(SuccessPublishVideoMessage successPublishVideo);
}
