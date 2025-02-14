package com.will.neet_tracker_app.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionForm {
  private Long unitId;
  private String unitName;
  private Long minutes;
  private Long seconds;
}
