package com.will.neet_tracker_app.controller;

import com.will.neet_tracker_app.model.api.SubmissionOutput;
import com.will.neet_tracker_app.model.api.SubmissionForm;
import com.will.neet_tracker_app.model.db.ProblemEntity;
import com.will.neet_tracker_app.model.db.SubmissionEntity;
import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.service.ProblemService;
import com.will.neet_tracker_app.service.SubmissionService;
import com.will.neet_tracker_app.service.UnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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

  @GetMapping
  public String viewHomepage(Model model) {
    List<UnitEntity> units = unitService.getUnits();
    model.addAttribute("units", units);
    return "index";
  }

  @GetMapping("/problem")
  public List<ProblemEntity> getProblems() {
    return problemService.getProblems();
  }

  @GetMapping("/submission")
  public List<SubmissionEntity> getSubmissions() {
    return submissionService.getSubmissions();
  }

  @GetMapping("/submission/leaderboard/{unitId}")
  public String getUnitLeaderboard(Model model, @PathVariable Long unitId) {
    UnitEntity unit = unitService.getUnitById(unitId);
    List<SubmissionOutput> submissions = submissionService.getSubmissionsByUnit(unitId);
    model.addAttribute("unitId", unit.getUnitId());
    model.addAttribute("unitName", unit.getUnitName());
    model.addAttribute("submissions", submissions);

    return "leaderboard";
  }

  @GetMapping("/problems/{unitId}")
  public String getProblemsByUnitId(Model model, @PathVariable Long unitId) {
    UnitEntity unit = unitService.getUnitById(unitId);
    List<ProblemEntity> problemEntities = problemService.getProblemsByUnitId(unitId);
    model.addAttribute("unitId", unit.getUnitId());
    model.addAttribute("unitName", unit.getUnitName());
    model.addAttribute("problemEntities", problemEntities);

    return "problems";
  }

  @GetMapping("/problems/completed/{problemId}")
  public String toggleCompletedForGivenProblem(Model model, @PathVariable Long problemId) {
    ProblemEntity updatedProblemEntity = problemService.toggleCompletedForGivenProblem(problemId);
    return "redirect:/neet/problems/" + updatedProblemEntity.getUnitEntity().getUnitId();
  }

  @GetMapping("/submission/{unitId}")
  public String getSubmissionsForm(Model model, @PathVariable Long unitId) {
    UnitEntity unit = unitService.getUnitById(unitId);
    SubmissionForm submissionForm = new SubmissionForm();
    submissionForm.setUnitId(unit.getUnitId());
    submissionForm.setUnitName(unit.getUnitName());
    model.addAttribute("submissionForm", submissionForm);
    return "submission_form";
  }

  @PostMapping("/submission/save")
  public String createSubmission(@ModelAttribute("submissionForm") SubmissionForm submissionForm) {
    UnitEntity updatedUnitEntity = unitService.updateLastRevised(submissionForm.getUnitId());
    submissionService.createSubmission(submissionForm, updatedUnitEntity);
    return "redirect:/neet/submission/leaderboard/" + submissionForm.getUnitId();
  }

  @GetMapping("/unit")
  public List<UnitEntity> getUnits() {
    return unitService.getUnits();
  }
}

