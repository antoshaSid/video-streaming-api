package com.asidliar.video.service.services;

import com.asidliar.video.service.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(final VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }
}
