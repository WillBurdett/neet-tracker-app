package com.will.neet_tracker_app.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "submissions")
public class SubmissionEntity {

  @Id
  @Column(name = "submission_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long submissionId;

  @ManyToOne
  @JoinColumn(name = "unit_id", nullable = false)
  private UnitEntity unitEntity;

  @Column(name = "time_taken")
  private Long timeTaken;

  @Column(name = "date")
  private LocalDate date;
}


