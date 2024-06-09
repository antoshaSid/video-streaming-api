package com.asidliar.video.metadata.service.services;

import com.asidliar.video.metadata.service.dto.VideoMetadataDto;
import com.asidliar.video.metadata.service.entities.VideoMetadataEntity;
import com.asidliar.video.metadata.service.repositories.VideoMetadataRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VideoMetadataServiceImpl implements VideoMetadataService {

    private final VideoMetadataRepository videoMetadataRepository;

    @Autowired
    public VideoMetadataServiceImpl(final VideoMetadataRepository videoMetadataRepository) {
        this.videoMetadataRepository = videoMetadataRepository;
    }

    @Override
    public VideoMetadataDto updateVideoMetadata(final VideoMetadataDto videoMetadataDto) {
        Optional<VideoMetadataEntity> optional = videoMetadataRepository.findById(videoMetadataDto.getVideoId());

        if (optional.isPresent()) {
            final VideoMetadataEntity videoMetadata = optional.get();

            if (videoMetadataDto.getTitle() != null) {
                videoMetadata.setTitle(videoMetadataDto.getTitle());
            }

            if (videoMetadataDto.getSynopsis() != null) {
                videoMetadata.setSynopsis(videoMetadataDto.getSynopsis());
            }

            if (videoMetadataDto.getDirector() != null) {
                videoMetadata.setDirector(videoMetadataDto.getDirector());
            }

            if (videoMetadataDto.getCast() != null) {
                videoMetadata.setCast(videoMetadataDto.getCast());
            }

            if (videoMetadataDto.getYear() != null) {
                videoMetadata.setYear(videoMetadataDto.getYear());
            }

            if (videoMetadataDto.getGenre() != null) {
                videoMetadata.setGenre(videoMetadataDto.getGenre());
            }

            if (videoMetadataDto.getRunningTime() != null) {
                videoMetadata.setRunningTime(videoMetadataDto.getRunningTime());
            }

            if (videoMetadataDto.getIsDeleted() != null) {
                videoMetadata.setIsDeleted(videoMetadataDto.getIsDeleted());
            }

            return new VideoMetadataDto(videoMetadataRepository.save(videoMetadata));
        } else {
            throw new NotFoundException("Video metadata not found");
        }
    }

    @Override
    public Page<VideoMetadataDto> getAllVideoMetadata(final Pageable pageable) {
        return videoMetadataRepository.findAll(pageable)
            .map(VideoMetadataDto::new);
    }

    @Override
    public List<VideoMetadataDto> searchVideoMetadata(String query) {
        return List.of();
    }
}