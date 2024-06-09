package com.asidliar.video.metadata.service.dto;

import com.asidliar.video.metadata.service.entities.VideoMetadataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Builder
@Data
public class VideoMetadataDto {

    @NotBlank(message = "Video ID is mandatory")
    private Long videoId;
    private String title;
    private String synopsis;
    private String director;
    private String cast;
    private Short year;
    private String genre;
    private Long runningTime;
    private Boolean isDeleted;

    public VideoMetadataDto(final VideoMetadataEntity videoMetadataEntity) {
        this.videoId = videoMetadataEntity.getId();
        this.title = videoMetadataEntity.getTitle();
        this.synopsis = videoMetadataEntity.getSynopsis();
        this.director = videoMetadataEntity.getDirector();
        this.cast = videoMetadataEntity.getCast();
        this.year = videoMetadataEntity.getYear();
        this.genre = videoMetadataEntity.getGenre();
        this.runningTime = videoMetadataEntity.getRunningTime();
        this.isDeleted = videoMetadataEntity.getIsDeleted();
    }
}
