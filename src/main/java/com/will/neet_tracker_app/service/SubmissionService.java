package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.api.SubmissionOutput;
import com.will.neet_tracker_app.model.api.SubmissionForm;
import com.will.neet_tracker_app.model.db.SubmissionEntity;
import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.repository.SubmissionRepo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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
    List<SubmissionEntity> orderedSubmissionEntities = submissionRepo.findAll()
        .stream()
        .filter(u -> u.getUnitEntity().getUnitId() == unitId)
        .sorted(Comparator.comparing(s -> s.getTimeTaken()))
        .collect(Collectors.toList());

    return createRankedSubmissionOutputs(orderedSubmissionEntities);

  }

  public List<SubmissionOutput> createRankedSubmissionOutputs(List<SubmissionEntity> submissionEntities) {
    List<SubmissionOutput> submissionOutputs = new ArrayList<>();
    int rank = 1;
    Long prevTimeTaken = null;

    for (int i = 0; i < submissionEntities.size(); i++) {
      SubmissionEntity current = submissionEntities.get(i);

      if (prevTimeTaken != null && current.getTimeTaken() != prevTimeTaken) {
        rank = i + 1;
      }

      String rankDisplay = (prevTimeTaken != null && current.getTimeTaken().equals(prevTimeTaken)) ? rank + "=" : String.valueOf(rank);
      submissionOutputs.add(convertEntityToOutput(rankDisplay, current));

      prevTimeTaken = current.getTimeTaken();
    }
    return submissionOutputs;
  }


  public SubmissionOutput convertEntityToOutput(String rank, SubmissionEntity submissionEntity) {
    return new SubmissionOutput(
        rank,
        formatTimeTaken(submissionEntity.getTimeTaken()),
        submissionEntity.getDate());
  }

  public String formatTimeTaken(Long seconds) {
    long minutesTaken = seconds / 60;
    long secondsRemaining = seconds % 60;
    return String.format("%02d:%02d", minutesTaken, secondsRemaining);
  }
}
