package com.will.neet_tracker_app.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SubmissionConverterTest {

  private final SubmissionConverter undertest = new SubmissionConverter();

  private final Long ID = 1L;
  private final Long SECONDS_TAKEN = 90L;
  private final String FORMATTED_TIME = "01:30";
  private final LocalDate DATE = LocalDate.of(2025,02,02);

  @Test
  void formatTimeTaken_happyPath() {
    // when
    String actual = undertest.formatTimeTaken(SECONDS_TAKEN);

    // then
    String expected = FORMATTED_TIME;
    assertEquals(expected, actual);
  }

}