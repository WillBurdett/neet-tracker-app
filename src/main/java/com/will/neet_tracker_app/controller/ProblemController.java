package com.will.neet_tracker_app.controller;

import com.will.neet_tracker_app.model.Problem;
import com.will.neet_tracker_app.service.ProblemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/neet")
public class ProblemController {

  private ProblemService problemService;

  public ProblemController(@Autowired ProblemService problemService) {
    this.problemService = problemService;
  }

  @GetMapping("/problem")
  public List<Problem> getProblems(){
    return problemService.getProblems();
  }

}
