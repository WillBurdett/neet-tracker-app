package com.will.neet_tracker_app.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "problems")
public class ProblemEntity {

  @Id
  @Column(name = "problem_id")
  private Long problemId;

  @Column(name = "problem_name")
  private String problemName;

  @ManyToOne
  @JoinColumn(name = "unit_id", nullable = false)
  private UnitEntity unitEntity;
}
