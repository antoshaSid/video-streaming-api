package com.asidliar.video.service.services;

import com.asidliar.video.service.dto.LoadVideoDto;
import com.asidliar.video.service.dto.PublishVideoDto;
import com.asidliar.video.service.messages.PublishVideoMessage;
import com.asidliar.video.service.services.producers.PublishVideoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class VideoServiceImpl implements VideoService {

    private final PublishVideoProducer publishVideoProducer;

    @Autowired
    public VideoServiceImpl(final PublishVideoProducer publishVideoProducer) {
        this.publishVideoProducer = publishVideoProducer;
    }

    @Override
    public void publishVideo(final PublishVideoDto video) {
        publishVideoProducer.publishVideo(new PublishVideoMessage(video.getTitle(), video.getContent()));
    }

    @Override
    public void deleteVideo(final Long videoId) {

    }

    @Override
    public LoadVideoDto loadVideo(final Long videoId) {
        return null;
    }

    @Override
    public SseEmitter playVideo(final Long videoId) {
        return null;
    }
}
