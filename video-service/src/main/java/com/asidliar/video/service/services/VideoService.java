package com.asidliar.video.service.services;

import com.asidliar.video.service.dto.LoadVideoDto;
import com.asidliar.video.service.dto.PublishVideoDto;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface VideoService {

    void publishVideo(PublishVideoDto video);

    void deleteVideo(Long videoId);

    LoadVideoDto loadVideo(Long videoId);

    SseEmitter playVideo(Long videoId);
}
