package com.will.neet_tracker_app.model.api;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionOutput {
  private String timeTaken;
  private LocalDate date;
}

