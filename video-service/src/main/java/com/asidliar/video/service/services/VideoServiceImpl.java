package com.asidliar.video.service.services;

import com.asidliar.video.service.dto.LoadVideoDto;
import com.asidliar.video.service.dto.PublishVideoDto;
import com.asidliar.video.service.messages.PublishVideoMessage;
import com.asidliar.video.service.services.producers.DelistVideoProducer;
import com.asidliar.video.service.services.producers.PublishVideoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class VideoServiceImpl implements VideoService {

    private final PublishVideoProducer publishVideoProducer;
    private final DelistVideoProducer delistVideoProducer;

    @Autowired
    public VideoServiceImpl(final PublishVideoProducer publishVideoProducer,
                            final DelistVideoProducer delistVideoProducer) {
        this.publishVideoProducer = publishVideoProducer;
        this.delistVideoProducer = delistVideoProducer;
    }

    @Override
    public void publishVideo(final PublishVideoDto video) {
        publishVideoProducer.publishVideo(new PublishVideoMessage(video.getTitle(), video.getContent()));
    }

    @Override
    public void deleteVideo(final Long videoId) {
        delistVideoProducer.delistVideo(videoId);
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
