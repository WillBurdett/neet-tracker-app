package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.db.SubmissionEntity;
import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.repository.SubmissionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

  private SubmissionRepo submissionRepo;

  public SubmissionService(@Autowired SubmissionRepo submissionRepo) {
    this.submissionRepo = submissionRepo;
  }

  public List<SubmissionEntity> getSubmissions() {
    return submissionRepo.findAll();
  }

  public void createSubmission(Long timeTaken,
      UnitEntity unitEntity) {
    SubmissionEntity submissionEntity = new SubmissionEntity();
    submissionEntity.setUnitEntity(unitEntity);
    submissionEntity.setTimeTaken(timeTaken);
    submissionEntity.setDate(unitEntity.getLastRevised());
    submissionRepo.save(submissionEntity);
  }
}
