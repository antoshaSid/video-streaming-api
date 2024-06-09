package com.asidliar.video.metadata.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VIDEO_METADATA")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VideoMetadataEntity {

    @Id
    @Column(name = "video_id")
    private Long id;

    private String title;

    private String synopsis;

    private String director;

    @Column(name = "video_cast")
    private String cast;

    private Short year;

    private String genre;

    @Column(name = "running_time")
    private Long runningTime;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}