package com.znz.tpip_backend.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.znz.tpip_backend.dto.FeedbackDto;
import com.znz.tpip_backend.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    boolean existsByMentorIdAndInternIdAndDate(Long id, Long id2, LocalDate now);

    Collection<FeedbackDto> findByInternId(Long internId);

    Collection<FeedbackDto> findByMentorId(Long mentorId);

    Collection<FeedbackDto> findByPlacementId(Long placementId);

    
} 


