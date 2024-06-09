package com.asidliar.video.service.services;

import com.asidliar.video.service.dto.LoadVideoDto;
import com.asidliar.video.service.dto.PlayVideoDto;
import com.asidliar.video.service.dto.PublishVideoDto;
import com.asidliar.video.service.messages.PublishVideoMessage;
import com.asidliar.video.service.repositories.VideoRepository;
import com.asidliar.video.service.services.producers.DelistVideoProducer;
import com.asidliar.video.service.services.producers.PublishVideoProducer;
import com.asidliar.video.service.services.producers.VideoImpressionProducer;
import com.asidliar.video.service.services.producers.VideoViewProducer;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    private final PublishVideoProducer publishVideoProducer;
    private final DelistVideoProducer delistVideoProducer;
    private final VideoImpressionProducer videoImpressionProducer;
    private final VideoViewProducer videoViewProducer;
    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(final PublishVideoProducer publishVideoProducer,
                            final DelistVideoProducer delistVideoProducer,
                            final VideoImpressionProducer videoImpressionProducer,
                            final VideoViewProducer videoViewProducer,
                            final VideoRepository videoRepository) {
        this.publishVideoProducer = publishVideoProducer;
        this.delistVideoProducer = delistVideoProducer;
        this.videoImpressionProducer = videoImpressionProducer;
        this.videoViewProducer = videoViewProducer;
        this.videoRepository = videoRepository;
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
        videoImpressionProducer.increaseVideoImpression(videoId);
        return null;
    }

    @Override
    public PlayVideoDto playVideo(final Long videoId) {
        return videoRepository.findById(videoId)
            .map(video -> {
                videoViewProducer.increaseVideoView(videoId);
                return new PlayVideoDto(video);
            }).orElseThrow(() -> new NotFoundException("Video not found"));
    }
}
