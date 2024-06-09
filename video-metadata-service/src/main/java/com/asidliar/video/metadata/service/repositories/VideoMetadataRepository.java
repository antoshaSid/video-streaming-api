package com.asidliar.video.metadata.service.repositories;

import com.asidliar.video.metadata.service.entities.VideoMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMetadataRepository extends JpaRepository<VideoMetadataEntity, Long> {

    @Modifying
    @Query("UPDATE VIDEO_METADATA v SET v.is_deleted = TRUE WHERE v.videoId = :videoId")
    void delistVideo(@Param("videoId") Long videoId);

    @Query("SELECT v FROM VIDEO_METADATA v " +
        "WHERE v.title LIKE %:query% OR " +
        "v.synopsis LIKE %:query% OR " +
        "v.director LIKE %:query% OR " +
        "v.year LIKE %:query% OR " +
        "v.genre LIKE %:query% OR " +
        "v.video_cast LIKE %:query%")
    List<VideoMetadataEntity> searchByQuery(@Param("query") String query);
}
