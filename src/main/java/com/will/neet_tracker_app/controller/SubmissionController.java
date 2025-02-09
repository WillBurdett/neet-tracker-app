package com.will.neet_tracker_app.controller;

import com.will.neet_tracker_app.model.Submission;
import com.will.neet_tracker_app.service.SubmissionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/neet")
public class SubmissionController {

  private SubmissionService submissionService;

  public SubmissionController(@Autowired SubmissionService submissionService) {
    this.submissionService = submissionService;
  }

  @GetMapping(value = "/submission")
  public List<Submission> getSubmissions(){
    return submissionService.getSubmissions();
  }

}
