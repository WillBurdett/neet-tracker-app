package com.will.neet_tracker_app.controller;

import com.will.neet_tracker_app.model.api.SubmissionRequest;
import com.will.neet_tracker_app.model.db.SubmissionEntity;
import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.service.SubmissionService;
import com.will.neet_tracker_app.service.UnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/neet/submission")
public class SubmissionController {

  private SubmissionService submissionService;
  private UnitService unitService;

  public SubmissionController(@Autowired SubmissionService submissionService, @Autowired UnitService unitService) {
    this.submissionService = submissionService;
    this.unitService = unitService;
  }

  @GetMapping
  public List<SubmissionEntity> getSubmissions(){
    return submissionService.getSubmissions();
  }

  @PostMapping
  public void createSubmission(@RequestBody SubmissionRequest submissionRequest){
    UnitEntity updatedUnitEntity = unitService.updateLastRevised(submissionRequest);
    submissionService.createSubmission(submissionRequest, updatedUnitEntity);
  }

}
