package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.Submission;
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

  public List<Submission> getSubmissions() {
    return submissionRepo.findAll();
  }
}
