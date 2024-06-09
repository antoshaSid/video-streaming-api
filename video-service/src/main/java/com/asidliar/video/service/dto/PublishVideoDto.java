package com.asidliar.video.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PublishVideoDto {

    @NotBlank(message = "Title is mandatory")
    String title;

    @NotBlank(message = "Content is mandatory")
    String content;
}
