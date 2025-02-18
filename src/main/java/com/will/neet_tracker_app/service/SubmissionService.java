package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.api.SubmissionOutput;
import com.will.neet_tracker_app.model.api.SubmissionForm;
import com.will.neet_tracker_app.model.db.SubmissionEntity;
import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.repository.SubmissionRepo;
import com.will.neet_tracker_app.utils.SubmissionConverter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

  private SubmissionRepo submissionRepo;
  private SubmissionConverter converter;

  public SubmissionService(@Autowired SubmissionRepo submissionRepo, @Autowired SubmissionConverter converter) {
    this.submissionRepo = submissionRepo;
    this.converter = converter;
  }

  public List<SubmissionEntity> getSubmissions() {
    return submissionRepo.findAll();
  }

  public void createSubmission(SubmissionForm submissionForm,
      UnitEntity unitEntity) {

    Long timeTaken = submissionForm.getSeconds() + (submissionForm.getMinutes() * 60);
    SubmissionEntity submissionEntity = new SubmissionEntity();
    submissionEntity.setUnitEntity(unitEntity);
    submissionEntity.setTimeTaken(timeTaken);
    submissionEntity.setDate(unitEntity.getLastRevised());
    submissionRepo.save(submissionEntity);
  }

  public List<SubmissionOutput> getSubmissionsByUnit(Long unitId) {
    return submissionRepo.findAll()
        .stream()
        .filter(u -> u.getUnitEntity().getUnitId() == unitId)
        .sorted(Comparator.comparing(s -> s.getTimeTaken()))
        .map(v -> converter.convertEntityToOutput(v))
        .collect(Collectors.toList());
  }
}
