package com.asidliar.video.metadata.service.services;

import com.asidliar.video.metadata.service.dto.VideoMetadataDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VideoMetadataService {

    VideoMetadataDto updateVideoMetadata(VideoMetadataDto videoMetadata);

    Page<VideoMetadataDto> getAllVideoMetadata(Pageable pageable);

    List<VideoMetadataDto> searchVideoMetadata(String query);
}
