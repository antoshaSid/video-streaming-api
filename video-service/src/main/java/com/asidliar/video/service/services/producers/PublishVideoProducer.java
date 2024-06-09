package com.asidliar.video.service.services.producers;

import com.asidliar.video.service.messages.PublishVideoMessage;

public interface PublishVideoProducer {

    void publishVideo(final PublishVideoMessage video);
}
