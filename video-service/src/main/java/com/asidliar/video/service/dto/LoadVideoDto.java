package com.asidliar.video.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoadVideoDto {

    Long videoId;
    String title;
    String synopsis;
    String director;
    String cast;
    Short yearOfRelease;
    String genre;
    Short runningTime;
}
