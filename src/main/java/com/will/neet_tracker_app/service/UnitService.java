package com.will.neet_tracker_app.service;

import com.will.neet_tracker_app.model.db.UnitEntity;
import com.will.neet_tracker_app.repository.UnitRepo;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

  private UnitRepo unitRepo;

  public UnitService(@Autowired UnitRepo unitRepo) {
    this.unitRepo = unitRepo;
  }

  public List<UnitEntity> getUnits(){
    return unitRepo.findAll()
        .stream()
        .sorted(Comparator.comparing(s -> s.getUnitId()))
        .collect(Collectors.toList());
  }

  public UnitEntity getUnitById(Long unitId) {
    Optional<UnitEntity> optionalUnit = unitRepo.findById(unitId);
    if (optionalUnit.isPresent()) {
      return optionalUnit.get();
    } else {
      throw new RuntimeException("unit does not exist");
    }
  }

  public UnitEntity updateLastRevised(Long unitId) {
    // check unit exists (could be a constraint on min/max of unitId int if we're controlling unit ids)
    Optional<UnitEntity> optionalUnit = unitRepo.findById(unitId);
    if (optionalUnit.isPresent()) {
      UnitEntity unitEntity = optionalUnit.get();
      unitEntity.setLastRevised(LocalDate.now());
      unitRepo.save(unitEntity);
      return unitEntity;
    } else {
      throw new RuntimeException("unit does not exist");
    }
  }

}
