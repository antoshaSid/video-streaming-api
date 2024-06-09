package com.asidliar.video.statistic.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VIDEO_STATISTICS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VideoStatisticEntity {

    @Id
    @Column(name = "video_id")
    private Long id;

    private Long impressions;

    private Long views;
}
