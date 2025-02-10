package com.will.neet_tracker_app.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubmissionRequest {
  private Long unitId;
  private Long timeTaken;
}
