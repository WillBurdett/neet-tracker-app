package com.will.neet_tracker_app.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.will.neet_tracker_app.model.api.SubmissionOutput;
import com.will.neet_tracker_app.model.db.SubmissionEntity;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SubmissionConverterTest {

  private final SubmissionConverter undertest = new SubmissionConverter();

  private final Long ID = 1L;
  private final Long SECONDS_TAKEN = 90L;
  private final String FORMATTED_TIME = "01:30";
  private final LocalDate DATE = LocalDate.of(2025,02,02);

  @Test
  void convertEntityToOutput_happyPath() {
    // given
    SubmissionEntity submissionEntity = new SubmissionEntity(ID, null, SECONDS_TAKEN, DATE);

    // when
    SubmissionOutput actual = undertest.convertEntityToOutput(submissionEntity);

    // then
    SubmissionOutput expected = new SubmissionOutput(FORMATTED_TIME, DATE);
    assertEquals(expected, actual);

  }
}