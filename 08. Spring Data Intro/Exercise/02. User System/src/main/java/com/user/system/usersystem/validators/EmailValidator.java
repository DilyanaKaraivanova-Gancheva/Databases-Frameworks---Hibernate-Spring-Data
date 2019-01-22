package com.user.system.usersystem.validators;


import com.user.system.usersystem.annotations.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
   public void initialize(Email constraint) {
   }

   public boolean isValid(String email, ConstraintValidatorContext context) {
      if (email.matches("^[A-Z0-9a-z]+[._-]?[A-Z0-9a-z]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,64}")){
         return true;
      }
      return false;
   }
}
