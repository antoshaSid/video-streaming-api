package com.asidliar.video.statistic.service.repositories;

import com.asidliar.video.statistic.service.entities.VideoStatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VideoStatisticRepository extends JpaRepository<VideoStatisticEntity, Long> {

    @Modifying
    @Query("UPDATE VIDEO_STATISTICS v SET v.impression = v.impression + 1 WHERE v.videoId = :videoId")
    void increaseVideoImpression(@Param("videoId") Long videoId);

    @Modifying
    @Query("UPDATE VIDEO_STATISTICS v SET v.view = v.view + 1 WHERE v.videoId = :videoId")
    void increaseVideoView(@Param("videoId") Long videoId);
}
