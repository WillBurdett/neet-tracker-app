package com.will.neet_tracker_app.controller;

import com.will.neet_tracker_app.model.db.ProblemEntity;
import com.will.neet_tracker_app.model.db.SubmissionEntity;
import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.service.ProblemService;
import com.will.neet_tracker_app.service.SubmissionService;
import com.will.neet_tracker_app.service.UnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/neet")
public class NeetController {

  private final ProblemService problemService;
  private final SubmissionService submissionService;
  private final UnitService unitService;

  @Autowired
  public NeetController(ProblemService problemService, SubmissionService submissionService, UnitService unitService) {
    this.problemService = problemService;
    this.submissionService = submissionService;
    this.unitService = unitService;
  }

  @GetMapping("/problem")
  public List<ProblemEntity> getProblems() {
    return problemService.getProblems();
  }

  @GetMapping("/submission")
  public List<SubmissionEntity> getSubmissions() {
    return submissionService.getSubmissions();
  }

  @GetMapping("/submission/{unitId}")
  public List<SubmissionEntity> getSubmissionsByUnit(@PathVariable Long unitId) {
    return submissionService.getSubmissionsByUnit(unitId);
  }

  @PostMapping("/submission")
  public void createSubmission(@RequestParam Long unitId,  @RequestParam Long timeTaken) {
    UnitEntity updatedUnitEntity = unitService.updateLastRevised(unitId);
    submissionService.createSubmission(timeTaken, updatedUnitEntity);
  }

  @GetMapping("/unit")
  public List<UnitEntity> getUnits() {
    return unitService.getUnits();
  }
}

