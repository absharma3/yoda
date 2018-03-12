package com.yoda.validation;

import com.amazonaws.services.codecommit.model.InvalidEmailException;
import com.yoda.models.User;
import org.springframework.stereotype.Component;


/**
 * Created by abhimanyus on 3/7/18.
 */
@Component
public class UserValidator {

    private EmailValidator emailValidator = new EmailValidator();

    public void validate(User user){
        if(!emailValidator.validate(user.getEmail())){
            throw new InvalidEmailException("User email " + user.getEmail() + " invalid");
        }
    }

}
