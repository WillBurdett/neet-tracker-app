package com.will.neet_tracker_app.repository;

import com.will.neet_tracker_app.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepo extends JpaRepository<Unit, Long> {

}
