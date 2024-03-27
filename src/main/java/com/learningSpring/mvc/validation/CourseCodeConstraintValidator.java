package com.learningSpring.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

  private String coursePrefix;

  @Override
  public void initialize(CourseCode theCourseCode) {
    coursePrefix = theCourseCode.value();
  }

  // @param value: the value that the user has entered for the course code
  // @param context: the constraint validator context
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    boolean result;

    if (value != null) {
      result = value.startsWith(coursePrefix);
    } else {
      result = true;
    }

    return result;

  }

}
