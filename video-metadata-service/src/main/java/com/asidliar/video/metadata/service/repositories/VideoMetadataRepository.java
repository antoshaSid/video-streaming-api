package com.asidliar.video.metadata.service.repositories;

import com.asidliar.video.metadata.service.entities.VideoMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoMetadataRepository extends JpaRepository<VideoMetadataEntity, Long> {

    @Modifying
    @Query("UPDATE VIDEO_METADATA v SET v.is_deleted = TRUE WHERE v.videoId = :videoId")
    void delistVideo(@Param("videoId") Long videoId);
}
