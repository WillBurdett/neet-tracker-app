package com.will.neet_tracker_app.repository;

import com.will.neet_tracker_app.model.db.SubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<SubmissionEntity, Long> {

}
