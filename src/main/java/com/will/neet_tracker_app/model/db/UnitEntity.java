package com.will.neet_tracker_app.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "units")
public class UnitEntity {

  @Id
  @Column(name = "unit_id")
  private Long unitId;

  @Column(name = "unit_name")
  private String unitName;

  @Column(name = "last_revised", nullable = true)
  private LocalDate lastRevised;

  @JsonIgnore
  @ToString.Exclude
  @OneToMany(mappedBy = "problemId", cascade = CascadeType.ALL)
  private List<ProblemEntity> problemEntities;

  @JsonIgnore
  @ToString.Exclude
  @OneToMany(mappedBy = "submissionId", cascade = CascadeType.ALL)
  private List<SubmissionEntity> submissionEntities;
}

