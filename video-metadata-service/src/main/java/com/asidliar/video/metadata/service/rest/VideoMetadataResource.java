package com.asidliar.video.metadata.service.rest;

import com.asidliar.video.metadata.service.dto.VideoMetadataDto;
import com.asidliar.video.metadata.service.services.VideoMetadataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video/metadata")
public class VideoMetadataResource {

    private final VideoMetadataService videoMetadataService;

    @Autowired
    public VideoMetadataResource(final VideoMetadataService videoMetadataService) {
        this.videoMetadataService = videoMetadataService;
    }

    @GetMapping("/{videoId}")
    ResponseEntity<VideoMetadataDto> getVideoMetadata(@PathVariable final Long videoId) {
        return ResponseEntity.ok(videoMetadataService.getVideoMetadata(videoId));
    }

    @PatchMapping
    ResponseEntity<VideoMetadataDto> updateVideoMetadata(@Valid @RequestBody VideoMetadataDto videoMetadata) {
        return ResponseEntity.ok(videoMetadataService.updateVideoMetadata(videoMetadata));
    }

    @GetMapping("/all")
    ResponseEntity<Page<VideoMetadataDto>> getAllVideoMetadata(@RequestParam("page") final Integer pageNumber,
                                                               @RequestParam("size") final Integer pageSize) {
        return ResponseEntity.ok(videoMetadataService.getAllVideoMetadata(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/search")
    ResponseEntity<List<VideoMetadataDto>> searchVideoMetadata(@RequestParam final String query) {
        return ResponseEntity.ok(videoMetadataService.searchVideoMetadata(query));
    }
}
