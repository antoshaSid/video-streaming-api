package com.asidliar.video.statistic.service.services;

import com.asidliar.video.statistic.service.dto.VideoStatisticDto;

public interface VideoStatisticService {

    VideoStatisticDto getVideoStatistic(Long videoId);
}
