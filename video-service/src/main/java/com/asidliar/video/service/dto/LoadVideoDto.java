package com.asidliar.video.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoadVideoDto {

    Long videoId;
    String content;
    String title;
    String synopsis;
    String director;
    String cast;
    Short yearOfRelease;
    String genre;
    Long runningTime;

    public LoadVideoDto(final VideoMetadataDto videoMetadata, final String content) {
        this.videoId = videoMetadata.getVideoId();
        this.content = content;
        this.title = videoMetadata.getTitle();
        this.synopsis = videoMetadata.getSynopsis();
        this.director = videoMetadata.getDirector();
        this.cast = videoMetadata.getCast();
        this.yearOfRelease = videoMetadata.getYear();
        this.genre = videoMetadata.getGenre();
        this.runningTime = videoMetadata.getRunningTime();

    }
}
