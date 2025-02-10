package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.api.SubmissionRequest;
import com.will.neet_tracker_app.model.db.SubmissionEntity;
import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.repository.UnitRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

  private UnitRepo unitRepo;

  public UnitService(@Autowired UnitRepo unitRepo) {
    this.unitRepo = unitRepo;
  }

  public List<UnitEntity> getUnits(){
    return unitRepo.findAll();
  }

  public UnitEntity updateLastRevised(SubmissionRequest submissionRequest) {
    // check unit exists (could be a constraint on min/max of unitId int if we're controlling unit ids)
    Optional<UnitEntity> optionalUnit = unitRepo.findById(submissionRequest.getUnitId());
    if (optionalUnit.isPresent()) {
      UnitEntity unitEntity = optionalUnit.get();
      unitEntity.setLastRevised(submissionRequest.getDate());
      unitRepo.save(unitEntity);
      return unitEntity;
    } else {
      throw new RuntimeException("unit does not exist");
    }
  }
}
