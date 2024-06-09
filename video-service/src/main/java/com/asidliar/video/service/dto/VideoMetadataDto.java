package com.asidliar.video.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class VideoMetadataDto {

    private Long videoId;
    private String title;
    private String synopsis;
    private String director;
    private String cast;
    private Short year;
    private String genre;
    private Long runningTime;
    private Boolean isDeleted;
}
