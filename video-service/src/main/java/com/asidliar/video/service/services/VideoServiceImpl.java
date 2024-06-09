package com.asidliar.video.service.services;

import com.asidliar.video.service.dto.LoadVideoDto;
import com.asidliar.video.service.dto.PlayVideoDto;
import com.asidliar.video.service.dto.PublishVideoDto;
import com.asidliar.video.service.dto.VideoMetadataDto;
import com.asidliar.video.service.messages.PublishVideoMessage;
import com.asidliar.video.service.repositories.VideoRepository;
import com.asidliar.video.service.services.producers.DelistVideoProducer;
import com.asidliar.video.service.services.producers.PublishVideoProducer;
import com.asidliar.video.service.services.producers.VideoImpressionProducer;
import com.asidliar.video.service.services.producers.VideoViewProducer;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoServiceImpl implements VideoService {

    private final PublishVideoProducer publishVideoProducer;
    private final DelistVideoProducer delistVideoProducer;
    private final VideoImpressionProducer videoImpressionProducer;
    private final VideoViewProducer videoViewProducer;
    private final VideoRepository videoRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public VideoServiceImpl(final PublishVideoProducer publishVideoProducer,
                            final DelistVideoProducer delistVideoProducer,
                            final VideoImpressionProducer videoImpressionProducer,
                            final VideoViewProducer videoViewProducer,
                            final VideoRepository videoRepository,
                            final RestTemplate restTemplate) {
        this.publishVideoProducer = publishVideoProducer;
        this.delistVideoProducer = delistVideoProducer;
        this.videoImpressionProducer = videoImpressionProducer;
        this.videoViewProducer = videoViewProducer;
        this.videoRepository = videoRepository;
        this.restTemplate = restTemplate;
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
        return videoRepository.findById(videoId)
            .map(video -> {
                final VideoMetadataDto videoMetadata = this.getVideoMetadata(videoId);

                if (videoMetadata != null && !videoMetadata.getIsDeleted()) {
                    videoImpressionProducer.increaseVideoImpression(videoId);
                    return new LoadVideoDto(videoMetadata, video.getContent());
                } else {
                    return null;
                }
        }).orElseThrow(() -> new NotFoundException("Video not found"));
    }

    @Override
    public PlayVideoDto playVideo(final Long videoId) {
        return videoRepository.findById(videoId)
            .map(video -> {
                final VideoMetadataDto videoMetadata = this.getVideoMetadata(videoId);

                if (videoMetadata != null && !videoMetadata.getIsDeleted()) {
                    videoViewProducer.increaseVideoView(videoId);
                    return new PlayVideoDto(video);
                } else {
                    return null;
                }
            }).orElseThrow(() -> new NotFoundException("Video not found"));
    }

    private VideoMetadataDto getVideoMetadata(final Long videoId) {
        final String url = "http://video-metadata-service/api/video/metadata/" + videoId;
        return restTemplate.getForObject(url, VideoMetadataDto.class);
    }
}
