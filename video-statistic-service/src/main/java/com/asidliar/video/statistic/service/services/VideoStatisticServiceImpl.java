package com.asidliar.video.statistic.service.services;

import com.asidliar.video.statistic.service.dto.VideoStatisticDto;
import com.asidliar.video.statistic.service.entities.VideoStatisticEntity;
import com.asidliar.video.statistic.service.repositories.VideoStatisticRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoStatisticServiceImpl implements VideoStatisticService {

    private final VideoStatisticRepository videoStatisticRepository;

    @Autowired
    public VideoStatisticServiceImpl(final VideoStatisticRepository videoStatisticRepository) {
        this.videoStatisticRepository = videoStatisticRepository;
    }

    @Override
    public VideoStatisticDto getVideoStatistic(final Long videoId) {
        final VideoStatisticEntity videoStatistic = videoStatisticRepository.findById(videoId)
            .orElseThrow(() -> new NotFoundException("Video not found"));

        return new VideoStatisticDto(
            videoStatistic.getId(),
            videoStatistic.getImpressions(),
            videoStatistic.getViews()
        );
    }
}
