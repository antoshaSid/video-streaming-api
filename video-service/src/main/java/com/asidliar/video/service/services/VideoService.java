package com.asidliar.video.service.services;

import com.asidliar.video.service.dto.LoadVideoDto;
import com.asidliar.video.service.dto.PlayVideoDto;
import com.asidliar.video.service.dto.PublishVideoDto;

public interface VideoService {

    void publishVideo(PublishVideoDto video);

    void deleteVideo(Long videoId);

    LoadVideoDto loadVideo(Long videoId);

    PlayVideoDto playVideo(Long videoId);
}
