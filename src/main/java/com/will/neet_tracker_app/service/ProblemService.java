package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.db.ProblemEntity;
import com.will.neet_tracker_app.repository.ProblemRepo;
import java.util.List;
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
}
