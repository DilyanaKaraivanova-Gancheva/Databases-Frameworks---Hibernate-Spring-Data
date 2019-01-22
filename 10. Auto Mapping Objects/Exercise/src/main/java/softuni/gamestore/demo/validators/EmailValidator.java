package softuni.gamestore.demo.validators;



import softuni.gamestore.demo.annotations.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
   public void initialize(Email constraint) {
   }

   public boolean isValid(String email, ConstraintValidatorContext context) {
      if (email.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\\.[a-zA-Z0-9_-]+$")){
         return true;
      }
      return false;
   }
}
