package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.Unit;
import com.will.neet_tracker_app.repository.UnitRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

  private UnitRepo unitRepo;

  public UnitService(@Autowired UnitRepo unitRepo) {
    this.unitRepo = unitRepo;
  }

  public List<Unit> getUnits(){
    return unitRepo.findAll();
  }
}
