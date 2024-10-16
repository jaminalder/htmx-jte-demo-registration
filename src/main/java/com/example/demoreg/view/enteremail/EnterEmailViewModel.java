package com.example.demoreg.view.enteremail;

import com.example.demoreg.view.shared.TextFieldViewModel;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class EnterEmailViewModel {
    private final TextFieldViewModel emailTextField;

    public EnterEmailViewModel() {
        this.emailTextField = new TextFieldViewModel("Email:", "Enter your email", "emailTextField");
    }

    public boolean validate() {
        String email = emailTextField.getValue();
        if (!StringUtils.hasLength(email)) {
            emailTextField.setError("Email is required");
            return false;
        }
        if (!email.contains("@")) {
            emailTextField.setError("Invalid email");
            return false;
        }
        if (email.endsWith("@gmail.com")) {
            emailTextField.setError("Email already used");
            return false;
        }
        return true;
    }

}
