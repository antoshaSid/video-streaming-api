package com.asidliar.video.statistic.service.rest;

import com.asidliar.video.statistic.service.dto.VideoStatisticDto;
import com.asidliar.video.statistic.service.services.VideoStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video/statistic")
public class VideoStatisticResource {

    private final VideoStatisticService videoStatisticService;

    @Autowired
    public VideoStatisticResource(final VideoStatisticService videoStatisticService) {
        this.videoStatisticService = videoStatisticService;
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<VideoStatisticDto> getVideoStatistic(@PathVariable final Long videoId) {
        return ResponseEntity.ok(videoStatisticService.getVideoStatistic(videoId));
    }
}
