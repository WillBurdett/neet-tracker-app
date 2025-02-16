package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.db.ProblemEntity;
import com.will.neet_tracker_app.repository.ProblemRepo;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

  private ProblemRepo problemRepo;

  public ProblemService(@Autowired ProblemRepo problemRepo) {
    this.problemRepo = problemRepo;
  }

  public List<ProblemEntity> getProblems() {
    return problemRepo.findAll();
  }

  public List<ProblemEntity> getProblemsByUnitId(Long unitId) {
    return problemRepo.findAll()
        .stream()
        .filter(p -> p.getUnitEntity().getUnitId().equals(unitId))
        .sorted(Comparator.comparing(v -> v.getProblemId()))
        .collect(Collectors.toList());
  }

  public ProblemEntity toggleCompletedForGivenProblem(Long problemId) {
    Optional<ProblemEntity> optionalProblemEntity = problemRepo.findById(problemId);

    if (optionalProblemEntity.isPresent()) {
      ProblemEntity problemEntity = optionalProblemEntity.get();
      boolean previousCompletedStatus = problemEntity.isCompleted();
      boolean updatedCompletedStatus = !previousCompletedStatus;
      problemEntity.setCompleted(updatedCompletedStatus);
      problemRepo.save(problemEntity);
      return problemEntity;
    } else {
      throw new RuntimeException("problem not found with id " + problemId);
    }
  }
}
