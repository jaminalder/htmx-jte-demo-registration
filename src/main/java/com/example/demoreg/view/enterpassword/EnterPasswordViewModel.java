package com.example.demoreg.view.enterpassword;

import com.example.demoreg.view.shared.TextFieldViewModel;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Random;

@Getter
public class EnterPasswordViewModel {
    private int passwordStrength;
    private final TextFieldViewModel passwordTextField;
    private final TextFieldViewModel repeatPasswordTextField;

    public EnterPasswordViewModel() {
        passwordStrength = 0;
        passwordTextField = new TextFieldViewModel("Password:", "Enter your password", "passwordTextField");
        passwordTextField.setHint("Please enter at least 8 characters with lowercase, uppercase letters and digits");
        repeatPasswordTextField = new TextFieldViewModel("Repeat Password:", "Repeat your password", "repeatPasswordTextField");
    }

    public boolean validate() {
        String password = passwordTextField.getValue();
        String repeatPassword = repeatPasswordTextField.getValue();

        passwordTextField.setError(null);
        repeatPasswordTextField.setError(null);

        boolean isValid = true;

        if (!StringUtils.hasLength(password)) {
            passwordTextField.setError("Please enter a password");
            isValid = false;
        } else if (!password.matches("\\S{8,100}")) {
            passwordTextField.setError("Password must be at least 8 characters");
            isValid = false;
        } else if (!password.matches(".*[0-9].*")) {
            passwordTextField.setError("Password must contain digits");
            isValid = false;
        } else if (!password.matches(".*[a-z].*")) {
            passwordTextField.setError("Password must contain lowercase letters");
            isValid = false;
        } else if (!password.matches(".*[A-Z].*")) {
            passwordTextField.setError("Password must contain uppercase letters");
            isValid = false;
        } else if (!password.equals(repeatPassword)) {
            repeatPasswordTextField.setError("Repeated password is not equal");
            isValid = false;
        }

        if(isValid) {
            passwordStrength = 100;
        } else {
            passwordStrength = new Random().nextInt(95);
        }

        return isValid;
    }

}
