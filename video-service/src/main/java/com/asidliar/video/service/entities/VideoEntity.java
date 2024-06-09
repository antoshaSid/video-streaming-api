package com.asidliar.video.service.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VIDEOS")
@NoArgsConstructor
@Getter
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    public VideoEntity(final String content) {
        this.content = content;
    }
}
