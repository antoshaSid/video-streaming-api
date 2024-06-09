package com.asidliar.video.service.messages;

public record SuccessPublishVideoMessage(Long videoId, String title, String content) {
}
