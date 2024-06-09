package com.asidliar.video.service.dto;

import com.asidliar.video.service.entities.VideoEntity;
import lombok.Value;

@Value
public class PlayVideoDto {

    Long videoId;
    String content;

    public PlayVideoDto(final VideoEntity videoEntity) {
        this.videoId = videoEntity.getId();
        this.content = videoEntity.getContent();
    }
}