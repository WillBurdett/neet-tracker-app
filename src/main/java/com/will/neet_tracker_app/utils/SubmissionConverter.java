package com.will.neet_tracker_app.utils;

import com.will.neet_tracker_app.model.api.SubmissionOutput;
import com.will.neet_tracker_app.model.db.SubmissionEntity;
import org.springframework.stereotype.Component;

@Component
public class SubmissionConverter {

  public SubmissionOutput convertEntityToOutput(SubmissionEntity submissionEntity) {
    return new SubmissionOutput(formatTimeTaken(submissionEntity.getTimeTaken()), submissionEntity.getDate());
  }

  private String formatTimeTaken(Long seconds) {
    long minutesTaken = seconds / 60;
    long secondsRemaining = seconds % 60;
    return String.format("%02d:%02d", minutesTaken, secondsRemaining);
  }

}
