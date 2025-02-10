package com.will.neet_tracker_app.controller;


import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.service.UnitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/neet/unit")
public class UnitController {

  private UnitService unitService;

  public UnitController(@Autowired UnitService unitService) {
    this.unitService = unitService;
  }

  @GetMapping
  public List<UnitEntity> getUnits(){
    return unitService.getUnits();
  }

}
