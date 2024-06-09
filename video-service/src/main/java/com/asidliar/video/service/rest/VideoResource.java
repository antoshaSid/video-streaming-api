package com.asidliar.video.service.rest;

import com.asidliar.video.service.dto.LoadVideoDto;
import com.asidliar.video.service.dto.PlayVideoDto;
import com.asidliar.video.service.dto.PublishVideoDto;
import com.asidliar.video.service.services.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoResource {

    private final VideoService videoService;

    @Autowired
    public VideoResource(final VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<String> publishVideo(@Valid @RequestBody final PublishVideoDto video) {
        videoService.publishVideo(video);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<LoadVideoDto> loadVideo(@PathVariable final Long videoId) {
        return ResponseEntity.ok(videoService.loadVideo(videoId));
    }

    @DeleteMapping("/{videoId}")
    public ResponseEntity<String> deleteVideo(@PathVariable final Long videoId) {
        videoService.deleteVideo(videoId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{videoId}/play")
    public ResponseEntity<PlayVideoDto> playVideo(@PathVariable final Long videoId) {
        return ResponseEntity.ok(videoService.playVideo(videoId));
    }
}
