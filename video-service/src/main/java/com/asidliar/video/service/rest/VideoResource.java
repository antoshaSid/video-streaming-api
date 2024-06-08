package com.asidliar.video.service.rest;

import com.asidliar.video.service.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/video")
public class VideoResource {

    private final VideoService videoService;

    @Autowired
    public VideoResource(final VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<String> publishVideo() {
        return null;
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<String> loadVideo(@PathVariable final Long videoId) {
        return null;
    }

    @DeleteMapping("/{videoId}")
    public ResponseEntity<String> deleteVideo(@PathVariable final Long videoId) {
        return null;
    }

    @GetMapping("/{videoId}/play")
    public SseEmitter playVideo(@PathVariable final Long videoId) {
        return null;
    }
}
